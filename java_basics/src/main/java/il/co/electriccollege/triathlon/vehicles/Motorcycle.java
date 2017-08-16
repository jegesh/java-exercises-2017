package il.co.electriccollege.triathlon.vehicles;

/**
 * Created by yaakov on 8/16/17.
 */
public class Motorcycle extends Vehicle {

    public Motorcycle() {
        super(20, 10);
    }

    @Override
    protected int getGasTankVolume() {
        return 50;
    }

    @Override
    protected int getGasBurnRate() {
        return 5;
    }

    @Override
    public int getTopSpeed() {
        return 50;
    }
}
