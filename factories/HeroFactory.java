package factories;

import entities.heroes.Hero;

public interface HeroFactory {
    Hero create(String heroName, String heroType);
}
