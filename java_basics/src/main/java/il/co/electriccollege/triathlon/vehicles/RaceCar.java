package il.co.electriccollege.triathlon.vehicles;

/**
 * Created by yaakov on 8/16/17.
 */
public class RaceCar extends Vehicle {

    public RaceCar() {
        super(40, 20);
    }

    @Override
    protected int getGasTankVolume() {
        return 150;
    }

    @Override
    protected int getGasBurnRate() {
        return 25;
    }

    @Override
    public int getTopSpeed() {
        return 180;
    }
}
