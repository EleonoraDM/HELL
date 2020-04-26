package repositories;

import entities.heroes.Hero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {
    private List<Hero> registeredHeroes;

    public HeroRepositoryImpl() {
        this.registeredHeroes = new ArrayList<>();
    }

    @Override
    public Hero getByName(String heroName) {
        Hero hero = this.registeredHeroes
                .stream()
                .filter(h -> h.getName().equals(heroName))
                .findFirst()
                .orElse(null);

        return hero;
    }

    @Override
    public void addHero(Hero hero) {
        this.registeredHeroes.add(hero);
    }

    @Override
    public Collection<Hero> getAll() {
        return Collections.unmodifiableList(this.registeredHeroes);
    }
}
