package il.co.electriccollege.triathlon.vehicles;

/**
 * Created by yaakov on 8/16/17.
 */
public class Tractor extends Vehicle {

    public Tractor() {
        super(3, 2);
    }

    @Override
    protected int getGasTankVolume() {
        return 100;
    }

    @Override
    protected int getGasBurnRate() {
        return 4;
    }

    @Override
    public int getTopSpeed() {
        return 12;
    }
}
