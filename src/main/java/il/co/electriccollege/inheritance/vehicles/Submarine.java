package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

public class Submarine extends Vehicle implements Submergeable {

    public Submarine(int speed) {
        super(speed);
    }

    @Override
    public boolean isUnderwater() {
        return this.speed > 20;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 24 * 60;
    }

    @Override
    public String getMedium() {
        return "water";
    }
}
