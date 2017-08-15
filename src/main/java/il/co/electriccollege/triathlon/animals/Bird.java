package il.co.electriccollege.triathlon.animals;
import il.co.electriccollege.triathlon.faces.Flyable;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Bird extends Animal implements Flyable{
    private int baseSpeed;
    private int topSpeed;
    private int currentSpeed;

    public Bird(int baseSpeed, int topSpeed) throws SpeedException {
        super();
        this.baseSpeed = baseSpeed;
        if(baseSpeed > topSpeed){
            int cProposal =  baseSpeed;
            throw new SpeedException("Base speed have to be higher than topSpeed", cProposal);
        }else{
            this.topSpeed = topSpeed;
        }

    }
    @Override
    public int move(int raceTime) {
        return currentSpeed*raceTime;
    }
    public void setBaseSpeed(int baseSpeed){
        this.baseSpeed = baseSpeed;
    }
    @Override
    public int getBaseSpeed() {
        return baseSpeed;
    }

    @Override
    public void accelerate() {

        if(currentSpeed <= topSpeed-10) currentSpeed+=10;
        else currentSpeed = topSpeed;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void decelerate() {
        if(currentSpeed >= 10) currentSpeed-=10;
        else currentSpeed = 0;
    }

    @Override
    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public void rest() {
        currentSpeed = 0;
    }

    @Override
    public boolean canFly() {
        return true;
    }
}
