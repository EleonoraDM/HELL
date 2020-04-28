package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriterImpl implements OutputWriter {
    private BufferedWriter writer;

    public OutputWriterImpl() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void writeLine(String output) throws IOException {
        this.writer.write(output);
    }

    @Override
    public void writeLine(String format, Object... params) throws IOException {
        this.writer.write(String.format(format, params));
    }
}
