package repositories;

import entities.items.CommonItem;
import entities.items.Item;
import entities.items.Recipe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToInt(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToInt(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToInt(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.values().stream().mapToInt(Item::getHitPointsBonus).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.values().stream().mapToInt(Item::getDamageBonus).sum();
    }



    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    /**
     * When a hero has all of the items that a RecipeItem requires,
     * those items are being removed from his inventory,
     * along with the recipe,
     * and a CommonItem is put on their place, with the stats of the RecipeItem.
     * As if the items have combined with the recipe in order to create a stronger item.
     */
    private void checkRecipes() {

        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                requiredItems.remove(item.getName());
            }
            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
                break;
            }
        }
    }

    private void combineRecipe(Recipe recipe) {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);

        }
        //TODO: Initialize the newItem variable, with an object of the CommonItem class.
        //TODO: Initialize the newItem variable, with the stat bonuses of the "recipe" parameter.

        Item newItem = new CommonItem(
                recipe.getName(),
                recipe.getStrengthBonus(),
                recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(),
                recipe.getHitPointsBonus(),
                recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);

        this.recipeItems.remove(recipe.getName());
    }
}