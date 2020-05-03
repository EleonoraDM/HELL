package commands;

import common.OutputMessages;
import entities.heroes.Hero;
import repositories.HeroRepository;

public class InspectHeroCommand implements Command {
    private HeroRepository heroRepository;

    private String[] params;

    public InspectHeroCommand(HeroRepository heroRepository, String...parameters) {
        this.heroRepository = heroRepository;
        this.params = parameters;
    }

    @Override
    public String execute() {
        String name = this.params[0];

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
}
