package il.co.electriccollege.triathlon.animals;

import il.co.electriccollege.triathlon.faces.Submergeable;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Fish extends Animal implements Submergeable {
    private int baseSpeed;
    private int topSpeed;
    private int currentSpeed;
    private int maxTimeUnderwater;

    @Override
    public int move(int raceTime) {
        if(this.initialEnergy > this.energyBurnRate*currentSpeed*raceTime){
            return currentSpeed*raceTime;
        }
        else{
            this.rest();
            return 0;
        }
    }

    @Override
    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed){
        this.baseSpeed = baseSpeed;
    }
    @Override
    public void accelerate() {
        if(currentSpeed <= topSpeed-10) currentSpeed+=10;
        else currentSpeed = topSpeed;
    }

    @Override
    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    @Override
    public void decelerate() {
        if(currentSpeed >= 10) currentSpeed-=10;
        else currentSpeed = 0;
    }

    @Override
    public int getTopSpeed() {
        return this.topSpeed;
    }

    public void rest() {
        this.currentSpeed = 0;
    }

    @Override
    public boolean canSwim() {
        return true;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return maxTimeUnderwater;
    }
    public void setMaxTimeUnderwater(int maxTimeUnderwater){
        this.maxTimeUnderwater = maxTimeUnderwater;
    }
}
