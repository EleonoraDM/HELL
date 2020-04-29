package entities.heroes;

import common.OutputMessages;
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
                        Map<String, Item> itemMap = (Map<String, Item>) declaredField.get(this.inventory);
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
        this.increaseStats(item);
    }

    private void increaseStats(Item item) {
        this.setStrength((int) (this.getStrength() + item.getStrengthBonus()));
        this.setAgility((int) (this.getAgility() + item.getAgilityBonus()));
        this.setIntelligence((int) (this.getIntelligence() + item.getIntelligenceBonus()));
        this.setHitPoints((int) (this.getHitPoints() + item.getHitPointsBonus()));
        this.setDamage((int) (this.getDamage() + item.getDamageBonus()));
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);

        Collection<Item> items = this.getItems();
        for (Item item : items) {
            if (item.getName().equals(recipe.getName())) {
                this.setNewStats(recipe);
            }
        }
    }

    private void setNewStats(Recipe recipe) {
        this.setStrength((int) (this.inventory.getTotalStrengthBonus() + this.getStrength()));
        this.setAgility((int) (this.inventory.getTotalAgilityBonus() + this.getAgility()));
        this.setIntelligence((int) (this.inventory.getTotalIntelligenceBonus() + this.getIntelligence()));
        this.setHitPoints((int) (this.inventory.getTotalHitPointsBonus() + this.getHitPoints()));
        this.setDamage((int) (this.inventory.getTotalDamageBonus() + this.getDamage()));
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

        Collection<Item> items = this.getItems();

        if (items.isEmpty()) {
            builder.append("None");
        } else {
            String itemsResult = items.stream().map(Item::getName).collect(Collectors.joining(", "));
            builder.append(itemsResult);
        }
        return builder.toString();
    }
}
