package il.co.electriccollege.triathlon.animals;

/**
 * Created by yaakov on 8/16/17.
 */
public class Cheetah extends Animal {

    public Cheetah() {
        super(20, 5);
    }

    @Override
    public int getTopSpeed() {
        return 30;
    }

    @Override
    protected int getRestLength() {
        return 30;
    }

    @Override
    protected int getInitialEnergy() {
        return 200;
    }

    @Override
    protected int getEnergyBurnRate() {
        return 15;
    }
}
