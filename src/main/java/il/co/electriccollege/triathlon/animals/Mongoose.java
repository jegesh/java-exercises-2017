package il.co.electriccollege.triathlon.animals;

/**
 * Created by yaakov on 8/16/17.
 */
public class Mongoose extends Animal {
    public Mongoose() {
        super(4, 2);
    }

    @Override
    public int getTopSpeed() {
        return 10;
    }

    @Override
    protected int getRestLength() {
        return 15;
    }

    @Override
    protected int getInitialEnergy() {
        return 50;
    }

    @Override
    protected int getEnergyBurnRate() {
        return 5;
    }
}
