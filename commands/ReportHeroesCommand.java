package commands;

import entities.heroes.Hero;
import repositories.HeroRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportHeroesCommand extends CommandImpl {

    public ReportHeroesCommand(HeroRepository heroRepository) {
        this.setHeroRepository(heroRepository);
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();

        Collection<Hero> heroes = this.getHeroRepository().getAll();

        Comparator<Hero> comparator =
                Comparator.comparing(hero -> hero.getStrength() + hero.getAgility() + hero.getIntelligence()
                );
        comparator = comparator.thenComparing(hero -> hero.getHitPoints() + hero.getDamage());

        List<Hero> sortedHeroes = heroes.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        sortedHeroes.forEach(hero -> builder
                .append(String.format("%d. ", (sortedHeroes.indexOf(hero) + 1)))
                .append(hero.toString())
                .append(System.lineSeparator()));

        return builder.toString();
    }
}
