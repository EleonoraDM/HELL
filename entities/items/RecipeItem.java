package entities.items;

import java.util.*;

public class RecipeItem extends ItemImpl implements Recipe {
    private List<String> requiredItems;

    public RecipeItem(
            String name,
            int strengthBonus,
            int agilityBonus,
            int intelligenceBonus,
            int hitPointsBonus,
            int damageBonus,
            String... requiredItems) {

        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = new ArrayList<String>(Arrays.asList(requiredItems));
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }
}
