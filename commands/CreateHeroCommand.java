package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import factories.HeroFactory;
import repositories.HeroRepository;

public class CreateHeroCommand implements Command {
    private HeroFactory heroFactory;
    private HeroRepository heroRepository;

    private String[] params;

    public CreateHeroCommand(HeroFactory heroFactory, HeroRepository heroRepository, String...parameters) {
        this.heroFactory = heroFactory;
        this.heroRepository = heroRepository;
        this.params = parameters;
    }

    @Override
    public String execute() {
        String heroName = this.params[0];
        String heroType = this.params[1];

        Hero hero = this.heroFactory.create(heroName, heroType);
        this.heroRepository.addHero(hero);

        return String.format(OutputMessages.HERO_CREATED, heroType, heroName);
    }
}
