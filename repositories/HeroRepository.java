package repositories;

import entities.heroes.Hero;

import java.util.Collection;

public interface HeroRepository {
    Hero getByName(String heroName);
    void addHero(Hero hero);
    Collection<Hero> getAll();
}
