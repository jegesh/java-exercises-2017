package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by borka on 8/12/2017.
 */
public class Submarine extends Vehicle implements Submergeable {
    @Override
    public int getBaseSpeed() {
        return super.getBaseSpeed();
    }

    @Override
    public int getCurrentSpeed() {
        return super.getCurrentSpeed();
    }

    @Override
    public int getTopSpeed() {
        return super.getTopSpeed();
    }

    @Override
    public void acceleration() {
        super.acceleration();
    }

    @Override
    public void deceleration() {
        super.deceleration();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    protected int getTankVolume() {
        return 0;
    }

    protected int gasBurnRate() {
        return 0;
    }

    public int move() {
        return 0;
    }

    public void dying() {

    }
}
