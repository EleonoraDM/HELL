package io;

public interface CommandProcessor {

    void setCommand(String command, String... parameters);

    String invoke(String commandName);
}
