import core.Engine;
import core.EngineImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}