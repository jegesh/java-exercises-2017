package il.co.electriccollege.triathlon.animals;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Dog extends Animal {
    private int baseSpeed;
    private int topSpeed;
    private static int currentSpeed;
    @Override
    public int move() {
        return 0;
    }

    @Override
    public int getBaseSpeed() {
        return 0;
    }

    @Override
    public void accelerate() {

    }

    @Override
    public int getCurrentSpeed() {
        return 0;
    }

    @Override
    public void decelerate() {

    }

    @Override
    public int getTopSpeed() {
        return 0;
    }


    public void rest() {

    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canRun() {
        return true;
    }

    @Override
    public boolean canSwim() {
        return false;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 0;
    }
}
