package il.co.electriccollege.triathlon.animals;

/**
 * Created by yaakov on 8/16/17.
 */
public class Squirrel extends Animal {
    private static final int SPEED = 1;
    private static final int RATE_OF_ACCELERATION = 2;
    private static final int REST_LENGTH = 10;

    public Squirrel() {
        super(SPEED, RATE_OF_ACCELERATION);
    }

    @Override
    public int getTopSpeed() {
        return 5;
    }

    @Override
    public int getRestLength() {
        return REST_LENGTH;
    }

    @Override
    protected int getInitialEnergy() {
        return 20;
    }

    @Override
    protected int getEnergyBurnRate() {
        return 3;
    }
}
