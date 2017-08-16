package il.co.electriccollege.triathlon.animals;

import il.co.electriccollege.triathlon.faces.Movable;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * Created by yaakov on 8/10/17.
 */
public abstract class Animal extends Movable{

    protected int energy;
    protected int restTime = 0;
    protected boolean isResting = false;
    private int baseSpeed;

    public Animal(int speed, int rateOfAcceleration){
        super(speed, rateOfAcceleration);
        if(speed == 0) throw new ValueException("Initial speed can not be zero");
        baseSpeed = speed;
        energy = getInitialEnergy();
    }

    public void rest() {
        isResting = true;
        restTime++;
        if(restTime == getRestLength()){
            isResting = false;
            restTime = 0;
            energy = getInitialEnergy();
            setSpeed(baseSpeed);
            return;
        }
    }

    @Override
    public void move() {
        if(isResting){
            rest();
            return;
        }
        if(getCurrentSpeed() == 0){
            rest();
            return;
        }
        if(energy == 0){
            decelerate();
        }else
            accelerate();
        energy -= getEnergyBurnRate();
        distance += getCurrentSpeed();
    }

    protected abstract int getRestLength();
    protected abstract int getInitialEnergy();
    protected abstract int getEnergyBurnRate();
}
