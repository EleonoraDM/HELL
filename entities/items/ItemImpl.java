package entities.items;

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
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
        //TODO validations for all fields!!!
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
