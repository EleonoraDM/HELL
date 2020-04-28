package io;

import common.Commands;
import common.ExceptionMessages;
import core.HellController;
import core.HellControllerImpl;

import java.util.Arrays;

public class CommandProcessorImpl implements CommandProcessor {
    private HellController controller;

    public CommandProcessorImpl() {
        this.controller = new HellControllerImpl();
    }

    @Override
    public String execute(String command, String... parameters) {
        String result = "";
        String heroName = null;
        String[] stats = null;

        if (command.toUpperCase().equals(Commands.HERO.name())) {
            heroName = parameters[0];
            String heroType = parameters[1];
            result = this.controller.createHero(heroName, heroType);

        } else if (command.toUpperCase().equals(Commands.ITEM.name())) {
            String itemName = parameters[0];
            heroName = parameters[1];
            stats = Arrays.copyOfRange(parameters, 2, parameters.length);
            result = this.controller.addItem(command, itemName, heroName, stats);

        } else if (command.toUpperCase().equals(Commands.RECIPE.name())) {
            String recipeName = parameters[0];
            heroName = parameters[1];
            stats = Arrays.copyOfRange(parameters, 2, parameters.length);
            result = this.controller.addRecipeItem(command, recipeName, heroName, stats);

        } else if (command.toUpperCase().equals(Commands.INSPECT.name())) {
            heroName = parameters[0];
            result = this.controller.inspectHero(heroName);

        } else if (command.toUpperCase().equals(Commands.QUIT.name())) {
            result = this.controller.reportHeroes();

        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMMAND);
        }
        return result;
    }
}
