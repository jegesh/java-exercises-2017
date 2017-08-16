package il.co.electriccollege.triathlon.vehicles;

import il.co.electriccollege.triathlon.faces.Movable;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * Created by yaakov on 8/16/17.
 */
public abstract class Vehicle extends Movable {
    protected int gasTankVolume;
    protected int gasBurnRate;
    private int baseSpeed;
    private int currentGasLevel;

    public Vehicle(int speed, int rateOfAcceleration) {
        super(speed, rateOfAcceleration);
        if(speed == 0) throw new ValueException("Initial speed can not be zero");
        baseSpeed = speed;
        currentGasLevel = getGasTankVolume();
    }

    @Override
    public void move() {
        if(getCurrentSpeed() == 0) return;
        if(currentGasLevel == 0){
            decelerate();
        }
        currentGasLevel -= gasBurnRate;
        distance += getCurrentSpeed();
    }

    protected abstract int getGasTankVolume();
    protected abstract int getGasBurnRate();
}
