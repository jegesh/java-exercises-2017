package il.co.electriccollege.triathlon.animals;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Fish extends Animal {
    private int baseSpeed;
    private int topSpeed;
    private int currentSpeed;
    private int maxTimeUnderwater;

    @Override
    public int move(int raceTime) {
        return currentSpeed*raceTime;
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
        return false;
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
