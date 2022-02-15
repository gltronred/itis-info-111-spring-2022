import java.io.*;
import java.util.*;

// Exception
// new Exception("message")
// throw e
// ResultType methodName(...) throws SomeExceptionType
// try { ... } catch(...) {...}

class EngineException extends Exception {}

class TooMuchSnowException extends Exception {
    private int height;
    TooMuchSnowException(int height) {
        this.height = height;
    }
    int getHeight() { return height; }
}

class Engine {
    private Random r;

    Engine() { r = new Random(); }
    void start() throws EngineException {
        if (r.nextInt(10) == 2) {
            throw new EngineException();
        }
        System.out.println("Started engine");
    }
    int get() throws EngineException {
        if (r.nextInt(10) == 2) {
            throw new EngineException();
        }
        return r.nextInt(1000);
    }
}

class Car {
    private Engine engine;
    private Random r;

    Car(Engine engine) {
        this.engine = engine;
        this.r = new Random();
    }
    void move() throws EngineException, TooMuchSnowException {
        engine.start();
        int snow = r.nextInt(10);
        if (snow > 6) {
            throw new TooMuchSnowException(snow);
        }
        int speed = engine.get() / 100;
        System.out.println("Moving car with speed " + speed);
    }
}

public class L0 {
    public static void main(String[] args) {
        Car car = new Car(new Engine());
        for (int i=0; i<30; i++) {
            try {
                System.out.println("====== " + i + " ======");
                car.move();
            } catch (TooMuchSnowException e) {
                System.out.println(e);
                for (int j=0; j<e.getHeight(); j++)
                    System.out.println("- Clean snow");
            } catch (EngineException e) {
                System.out.println(e);
                System.out.println("Repair engine");
            }
        }
    }
}
