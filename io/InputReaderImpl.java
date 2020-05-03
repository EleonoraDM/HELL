package io;

import core.CommandProcessor;
import core.CommandProcessorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputReaderImpl implements InputReader {
    private BufferedReader reader;
    private CommandProcessor processor;

    public InputReaderImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.processor = new CommandProcessorImpl();
    }

    @Override
    public String readLine() throws IOException {

            String[] tokens = this.reader.readLine().split("\\s+");
            String command = tokens[0];
            String[] data = Arrays.copyOfRange(tokens, 1, tokens.length);

        this.processor.setCommand(command, data);
        return this.processor.invoke(command);
    }
}
