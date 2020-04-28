package entities.heroes;

import entities.items.Item;
import entities.items.Recipe;
import repositories.HeroInventory;
import repositories.Inventory;
import repositories.ItemCollection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HeroImpl implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;


    protected HeroImpl(String name) {
        this.name = name;
        this.inventory = new HeroInventory();
        //TODO validation for all members!!!
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @SuppressWarnings("unchecked")
    @Override

    public Collection<Item> getItems() {
        //TODO Implementation - Implement the getItems() method of the Hero entities, with reflection.
        Collection<Item> items = null;

        Field[] declaredFields = HeroInventory.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(ItemCollection.class)) {
                declaredField.setAccessible(true);
                try {
                    Class<?> fieldType = declaredField.getType();
                    if (fieldType.equals(Map.class)) {
                        Inventory instance = new HeroInventory();
                        Map<String, Item> itemMap = (Map<String, Item>) declaredField.get(instance);
                        items = itemMap.values();
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return items;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder
                .append(String.format("%s: %s%n", this.getClass().getSimpleName(), this.getName()))
                .append(String.format("###HitPoints: %d%n", this.getHitPoints()))
                .append(String.format("###Damage: %d%n", this.getDamage()))
                .append(String.format("###Strength: %d%n", this.getStrength()))
                .append(String.format("###Agility: %d%n", this.getAgility()))
                .append(String.format("###Intelligence: %d%n", this.getIntelligence()))
                .append("###Items: ");

        String itemsResult = this.getItems().stream().map(Item::getName).collect(Collectors.joining(", "));
        builder.append(itemsResult);

        return builder.toString();
    }
}
