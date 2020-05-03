package factories;

import commands.*;
import common.Commands;
import common.ExceptionMessages;
import repositories.HeroRepository;
import repositories.HeroRepositoryImpl;

public class CommandFactoryImpl implements CommandFactory {
    private HeroFactory heroFactory;
    private HeroRepository heroRepository;
    private ItemFactory itemFactory;

    public CommandFactoryImpl() {
        this.heroFactory = new HeroFactoryImpl();
        this.heroRepository = new HeroRepositoryImpl();
        this.itemFactory = new ItemFactoryImpl();
    }

    @Override
    public Command createCommand(String commandName, String... params) {
        Command command = null;

        if (commandName.toUpperCase().equals(Commands.HERO.name())) {
            command = new CreateHeroCommand(this.heroFactory, this.heroRepository, params);

        } else if (commandName.toUpperCase().equals(Commands.ITEM.name())) {
            command = new AddItemCommand(this.itemFactory, this.heroRepository, params);

        } else if (commandName.toUpperCase().equals(Commands.RECIPE.name())) {
            command = new AddRecipeCommand(this.itemFactory, this.heroRepository, params);

        } else if (commandName.toUpperCase().equals(Commands.INSPECT.name())) {
            command = new InspectHeroCommand(this.heroRepository, params);

        } else if (commandName.toUpperCase().equals(Commands.QUIT.name())) {
            command = new ReportHeroesCommand(this.heroRepository);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMMAND);
        }
        return command;
    }
}
