package entities.heroes;

import common.Config;

public class Wizard extends HeroImpl {

    public Wizard(String name) {
        super(name);
        this.setStrength(Config.WIZARD_DEFAULT_STRENGTH);
        this.setAgility(Config.WIZARD_DEFAULT_AGILITY);
        this.setIntelligence(Config.WIZARD_DEFAULT_INTELLIGENCE);
        this.setHitPoints(Config.WIZARD_DEFAULT_HIT_POINTS);
        this.setDamage(Config.WIZARD_DEFAULT_DAMAGE);
    }
}
