package entities.items;

import common.ExceptionMessages;

public abstract class ItemImpl implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected ItemImpl(
            String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
            int damageBonus) {
        this.setName(name);
        this.setStrengthBonus(strengthBonus);
        this.setAgilityBonus(agilityBonus);
        this.setIntelligenceBonus(intelligenceBonus);
        this.setHitPointsBonus(hitPointsBonus);
        this.setDamageBonus(damageBonus);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_ITEM_NAME);
        }
        this.name = name;
    }

    private void setStrengthBonus(int strengthBonus) {
        if (strengthBonus < 0){
            throw new NullPointerException(ExceptionMessages.INVALID_STRENGTH);
        }
        this.strengthBonus = strengthBonus;
    }

    private void setAgilityBonus(int agilityBonus) {
        if (agilityBonus < 0){
            throw new NullPointerException(ExceptionMessages.INVALID_AGILITY);
        }
        this.agilityBonus = agilityBonus;
    }

    private void setIntelligenceBonus(int intelligenceBonus) {
        if (intelligenceBonus < 0){
            throw new NullPointerException(ExceptionMessages.INVALID_INTELLIGENCE);
        }
        this.intelligenceBonus = intelligenceBonus;
    }

    private void setHitPointsBonus(int hitPointsBonus) {
        if (hitPointsBonus < 0){
            throw new NullPointerException(ExceptionMessages.INVALID_HIT_POINTS);
        }
        this.hitPointsBonus = hitPointsBonus;
    }

    private void setDamageBonus(int damageBonus) {
        if (damageBonus < 0){
            throw new NullPointerException(ExceptionMessages.INVALID_DAMAGE);
        }
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder
                .append("Items:")
                .append(System.lineSeparator())
                .append(String.format("###Item: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("###+%d Strength", this.getStrengthBonus()))
                .append(System.lineSeparator())
                .append(String.format("###+%d Agility", this.getAgilityBonus()))
                .append(System.lineSeparator())
                .append(String.format("###+%d Intelligence", this.getIntelligenceBonus()))
                .append(System.lineSeparator())
                .append(String.format("###+%d HitPoints", this.getHitPointsBonus()))
                .append(System.lineSeparator())
                .append(String.format("###+%d Damage", this.getDamageBonus()));

        return builder.toString();
    }
}
