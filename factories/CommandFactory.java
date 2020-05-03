package factories;

import commands.Command;

public interface CommandFactory {
    Command createCommand(String commandName, String ... params);
}
