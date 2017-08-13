package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by borka on 8/12/2017.
 */
public class Submarine extends Vehicle implements Submergeable {
    public Submarine(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.println("moving");
    }

    @Override
    public void dying() {
        System.out.println("I'm metal box and moving under water");
    }
}
