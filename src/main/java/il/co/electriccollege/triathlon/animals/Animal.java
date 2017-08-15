package il.co.electriccollege.triathlon.animals;

import il.co.electriccollege.triathlon.faces.Movable;

/**
 * Created by IrKha on 14.08.2017.
 */
public abstract class Animal implements Movable {
    private int initialEnergy;
    private int energyBurnRate;

    public abstract void rest();
}
