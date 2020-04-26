package entities.items;

public abstract class ItemImpl implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected ItemImpl(
            String name,
            int strengthBonus,
            int agilityBonus,
            int intelligenceBonus,
            int hitPointsBonus,
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
                .append("Items:%n")
                .append(String.format("###Item: %s%n", this.getName()))
                .append(String.format("###+%d Strength%n", this.getStrengthBonus()))
                .append(String.format("###+%d Agility%n", this.getAgilityBonus()))
                .append(String.format("###+%d Intelligence%n", this.getIntelligenceBonus()))
                .append(String.format("###+%d HitPoints%n", this.getHitPointsBonus()))
                .append(String.format("###+%d Damage%n", this.getDamageBonus()));

        return super.toString();
    }
}
