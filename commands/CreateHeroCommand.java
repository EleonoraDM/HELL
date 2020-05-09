package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import factories.HeroFactory;
import repositories.HeroRepository;

public class CreateHeroCommand extends CommandImpl {

    public CreateHeroCommand(HeroFactory heroFactory, HeroRepository heroRepository,
                             String[] parameters) {
        super(parameters);
        this.setHeroFactory(heroFactory);
        this.setHeroRepository(heroRepository);
    }

    @Override
    public String execute() {
        String[] parameters = this.getParameters();
        String heroName = parameters[0];
        String heroType = parameters[1];

        Hero hero = this.getHeroFactory().create(heroName, heroType);
        this.getHeroRepository().addHero(hero);

        return String.format(OutputMessages.HERO_CREATED, heroType, heroName);
    }
}
