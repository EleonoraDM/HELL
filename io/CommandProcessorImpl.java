package io;

import commands.*;
import common.Commands;
import common.ExceptionMessages;
import factories.*;
import repositories.HeroRepository;
import repositories.HeroRepositoryImpl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandProcessorImpl implements CommandProcessor {
    private CommandFactory commandFactory;

    private Map<String, Command> commands;

    public CommandProcessorImpl() {
        this.commandFactory = new CommandFactoryImpl();
        this.commands = new LinkedHashMap<>();
    }

    @Override
    public void setCommand(String commandName, String... parameters) {
        Command command = this.commandFactory.createCommand(commandName, parameters);
        this.commands.put(commandName, command);
    }

    @Override
    public String invoke(String commandName) {
        String result = this.commands.get(commandName).execute();
        return result;
    }


}
