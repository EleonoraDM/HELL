package core;

import common.OutputMessages;
import entities.heroes.Hero;
import entities.items.CommonItem;
import entities.items.Item;
import entities.items.Recipe;
import factories.HeroFactory;
import factories.HeroFactoryImpl;
import factories.ItemFactory;
import factories.ItemFactoryImpl;
import repositories.HeroRepository;
import repositories.HeroRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HellControllerImpl implements HellController {
    private HeroFactory heroFactory;
    private ItemFactory itemFactory;
    private HeroRepository heroRepository;

    public HellControllerImpl() {
        this.heroFactory = new HeroFactoryImpl();
        this.itemFactory = new ItemFactoryImpl();
        this.heroRepository = new HeroRepositoryImpl();
    }

    @Override
    public String createHero(String heroName, String heroType) {
        Hero hero = this.heroFactory.create(heroName, heroType);
        this.heroRepository.addHero(hero);

        return String.format(OutputMessages.HERO_CREATED, heroType, heroName);
    }

    @Override
    public String addItem(String itemType, String name, String heroName, String... parameters) {
        Item item = ((CommonItem) this.itemFactory.create(itemType, name, heroName, parameters));
        Hero hero = this.heroRepository.getByName(heroName);
        hero.addItem(item);

        return String.format(OutputMessages.ITEM_ADDED, name, heroName);
    }

    @Override
    public String addRecipeItem(String itemType, String name, String heroName, String... parameters) {

        Recipe item = ((Recipe) this.itemFactory.create(itemType, name, heroName, parameters));
        Hero hero = this.heroRepository.getByName(heroName);
        hero.addRecipe(item);

        return String.format(OutputMessages.RECIPE_ADDED, name, heroName);
    }

    /**
     * The command should present information ONLY about the CommonItems from the registered heroes.
     *
     * @param name, which is the name of the given hero, who should be inspected.
     * @return this command should report information in the preliminary specified format.
     */

    @Override
    public String inspectHero(String name) {
        StringBuilder builder = new StringBuilder();

        Hero hero = this.heroRepository.getByName(name);
        builder
                .append(String.format("Hero: %s, Class: %s", hero.getName(), hero.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints(), hero.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", hero.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", hero.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", hero.getIntelligence()))
                .append(System.lineSeparator());

        if (hero.getItems().isEmpty()) {
            builder.append(OutputMessages.NO_ITEMS);
        } else {
            hero.getItems().forEach(item -> builder.append(item.toString()));
        }
        return builder.toString();
    }

    @Override
    public String reportHeroes() {
        StringBuilder builder = new StringBuilder();

        List<Hero> heroes = ((ArrayList<Hero>) this.heroRepository.getAll());

        Comparator<Hero> comparator =
                Comparator.comparing(hero -> hero.getStrength() + hero.getAgility() + hero.getIntelligence()
        );
        comparator = comparator.thenComparing(hero -> hero.getHitPoints() + hero.getDamage());

        List<Hero> sortedHeroes = heroes.stream().sorted(comparator.reversed()).collect(Collectors.toList());
        sortedHeroes.forEach(hero -> builder.append(hero.toString()));

        return builder.toString();
    }
}
