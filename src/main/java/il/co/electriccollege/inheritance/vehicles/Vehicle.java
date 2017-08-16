package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Movable;

/**
 * Created by borka on 8/12/2017.
 */
 public abstract class Vehicle implements Movable {

    // Movable Methods

    public int getBaseSpeed() {
        return 0;
    }

    public abstract int getCurrentSpeed();

    public abstract int getTopSpeed();

    public abstract void acceleration() ;

    public abstract void deceleration() ;

    // New Methods

    protected abstract int getTankVolume ();
    protected abstract int gasBurnRate ();

}
