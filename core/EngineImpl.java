package core;

import common.Commands;
import io.InputReader;
import io.InputReaderImpl;
import io.OutputWriter;
import io.OutputWriterImpl;

import java.io.IOException;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;

    public EngineImpl() {
        this.reader = new InputReaderImpl();
        this.writer = new OutputWriterImpl();
    }

    @Override
    public void run() throws IOException {

        while (true) {
            String result = null;

            try {
                result = this.reader.readLine();

                if (result.equals(Commands.QUIT.name())) {
                    break;
                }

            } catch (IOException e) {
                result = e.getMessage();
            }
            this.writer.writeLine(result);
        }
    }
}
