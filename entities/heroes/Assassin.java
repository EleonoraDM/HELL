package entities.heroes;

import common.Config;

public class Assassin extends HeroImpl {


    public Assassin(String name) {
        super(name);
        this.setStrength(Config.ASSASSIN_DEFAULT_STRENGTH);
        this.setAgility(Config.ASSASSIN_DEFAULT_AGILITY);
        this.setIntelligence(Config.ASSASSIN_DEFAULT_INTELLIGENCE);
        this.setHitPoints(Config.ASSASSIN_DEFAULT_HIT_POINTS);
        this.setDamage(Config.ASSASSIN_DEFAULT_DAMAGE);
    }

}
