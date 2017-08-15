package il.co.electriccollege.triathlon.animals;

import il.co.electriccollege.triathlon.faces.CanRunnable;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Dog extends Animal implements CanRunnable {
    private int baseSpeed;
    private int topSpeed;
    private int currentSpeed;
    private int maxTimeUnderwater;


    public Dog(int baseSpeed, int topSpeed) throws SpeedException {
        super();
        this.baseSpeed = baseSpeed;
        if (baseSpeed > topSpeed) {
            int cProposal = baseSpeed;
            throw new SpeedException("Base speed have to be higher than topSpeed", cProposal);
        } else {
            this.topSpeed = topSpeed;
        }
    }
    @Override
    public int move(int raceTime) {
        return currentSpeed*raceTime;
    }

    @Override
    public int getBaseSpeed() {
        return baseSpeed;
    }

    @Override
    public void accelerate() {

    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }
    public void setBaseSpeed(int baseSpeed){
        this.baseSpeed = baseSpeed;
    }
    @Override
    public void decelerate() {
        if(currentSpeed <= topSpeed-10) currentSpeed+=10;
        else currentSpeed = topSpeed;
    }

    @Override
    public int getTopSpeed() {
        return topSpeed;
    }


    public void rest() {
        this.currentSpeed = 0;
    }


    @Override
    public boolean canRun() {
        return true;
    }

}
