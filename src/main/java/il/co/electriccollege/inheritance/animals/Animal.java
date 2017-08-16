package il.co.electriccollege.inheritance.animals;

import il.co.electriccollege.inheritance.faces.Movable;

/**
 * Created by yaakov on 8/10/17.
 */
public abstract class Animal implements Movable{


    // Movable methods
    public int getBaseSpeed() {
        return 0;
    }

    public abstract int move();

    public abstract int getCurrentSpeed();

    public abstract int getTopSpeed();

    public abstract void acceleration();

    public abstract void deceleration();

    // Animal methods

    protected abstract void motion();

    //protected abstract void flavor();

    protected boolean breathesAir(){
        return true;
    }

    protected int energy(){
        return 100;
    }

    protected abstract int energyBurnRate();
    protected abstract int restTime();

}
