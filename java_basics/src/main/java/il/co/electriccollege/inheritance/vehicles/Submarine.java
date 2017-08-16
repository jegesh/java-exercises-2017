package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by yaakov on 8/14/17.
 */
public class Submarine extends Vehicle implements Submergeable {

    public Submarine(int speed) {
        super(speed);
    }

    public boolean isUnderwater() {
        return speed > 20;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 24 * 60;
    }

    @Override
    public String getMedium() {
        return "water";
    }

    @Override
    public Vehicle crash(Vehicle v) {
        return v;
    }
}
