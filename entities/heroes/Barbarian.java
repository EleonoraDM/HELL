package entities.heroes;

import common.Config;

public class Barbarian extends HeroImpl {


    public Barbarian(String name) {
        super(name);
        this.setStrength(Config.BARBARIAN_DEFAULT_STRENGTH);
        this.setAgility(Config.BARBARIAN_DEFAULT_AGILITY);
        this.setIntelligence(Config.BARBARIAN_DEFAULT_INTELLIGENCE);
        this.setHitPoints(Config.BARBARIAN_DEFAULT_HIT_POINTS);
        this.setDamage(Config.BARBARIAN_DEFAULT_DAMAGE);
    }



}
