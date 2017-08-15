package il.co.electriccollege.triathlon.animals;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Dog extends Animal {
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

    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canRun() {
        return true;
    }

    @Override
    public boolean canSwim() {
        return false;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return maxTimeUnderwater;
    }
    public void setMaxTimeUnderwater(int maxTimeUnderwater){
        this.maxTimeUnderwater = maxTimeUnderwater;
    }
}
