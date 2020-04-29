package io;

import java.io.IOException;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void writeLine(String output) throws IOException {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) throws IOException {
        System.out.printf(format, params);
    }
}
