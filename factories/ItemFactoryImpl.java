package factories;

import common.ExceptionMessages;
import entities.items.CommonItem;
import entities.items.Item;
import entities.items.Recipe;
import entities.items.RecipeItem;

import java.util.Arrays;

public class ItemFactoryImpl implements ItemFactory {

    @Override
    public Object create(String itemType, String name, String heroName, String... parameters) {


        Object item = null;

        int strengthBonus = Integer.parseInt(parameters[0]);
        int agilityBonus = Integer.parseInt(parameters[1]);
        int intelligenceBonus = Integer.parseInt(parameters[2]);
        int hitPointsBonus = Integer.parseInt(parameters[3]);
        int damageBonus = Integer.parseInt(parameters[4]);

        if (itemType.equals(Item.class.getSimpleName())) {

            item = new CommonItem(heroName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus,
                    damageBonus);

        } else if (itemType.equals(Recipe.class.getSimpleName())) {

            String[] requiredItems = Arrays.copyOfRange(parameters, 5, parameters.length);

            item = new RecipeItem(heroName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus,
                    damageBonus,
                    requiredItems);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ITEM_TYPE);
        }
        return item;
    }
}
