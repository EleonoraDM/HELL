package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import repositories.HeroRepository;

public class InspectHeroCommand extends CommandImpl {

    public InspectHeroCommand(HeroRepository heroRepository,
                              String[] parameters) {
        super(parameters);
        this.setHeroRepository(heroRepository);
    }

    @Override
    public String execute() {
        String name = this.getParameters()[0];

        StringBuilder builder = new StringBuilder();

        Hero hero = this.getHeroRepository().getByName(name);
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
}
