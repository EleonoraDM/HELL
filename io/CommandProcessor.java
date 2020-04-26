package io;

public interface CommandProcessor {
    String execute(String command, String... parameters);
}
