package factories;

import entities.heroes.Assassin;
import entities.heroes.Barbarian;
import entities.heroes.Hero;
import entities.heroes.Wizard;

public class HeroFactoryImpl implements HeroFactory {

    @Override
    public Hero create(String heroName, String heroType) {
        Hero hero = null;

        if (heroType.equals(Assassin.class.getSimpleName())) {
            hero = new Assassin(heroName);

        } else if (heroType.equals(Barbarian.class.getSimpleName())) {
            hero = new Barbarian(heroName);

        } else {
            hero = new Wizard(heroName);
        }
        return hero;
    }
}
