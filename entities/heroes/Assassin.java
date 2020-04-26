package entities.heroes;

public class Assassin extends HeroImpl {
    private static final int STRENGTH = 25;
    private static final int AGILITY = 100;
    private static final int INTELLIGENCE = 15;
    private static final int HIT_POINTS = 150;
    private static final int DAMAGE = 300;


    public Assassin(String name) {
        super(name);
        this.setStrength(STRENGTH);
        this.setAgility(AGILITY);
        this.setIntelligence(INTELLIGENCE);
        this.setHitPoints(HIT_POINTS);
        this.setDamage(DAMAGE);
    }
}
