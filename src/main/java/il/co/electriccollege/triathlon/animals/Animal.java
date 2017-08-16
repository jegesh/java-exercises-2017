package il.co.electriccollege.triathlon.animals;
import il.co.electriccollege.triathlon.faces.*;


/**
 * Created by IrKha on 14.08.2017.
 */
public abstract class Animal implements Movable {

    protected int initialEnergy;
    protected int energyBurnRate;
    protected int baseSpeed;
    protected int topSpeed;
    protected int currentSpeed;


    public void setInitialEnergy(int initialEnergy){
        this.initialEnergy = initialEnergy;
    }
    public void setEnergyBurnRate(int energyBurnRate){
        this.energyBurnRate = energyBurnRate;
    }

    /**
     * getters
     * @return
     */
    @Override
    public int getBaseSpeed() {
        return baseSpeed;
    }
    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }
    @Override
    public int getTopSpeed() {
        return topSpeed;
    }
    @Override
    public void accelerate() {
        if(currentSpeed <= topSpeed-10) currentSpeed+=10;
        else currentSpeed = topSpeed;
        this.energyBurnRate-=5;
    }
    @Override
    public int move(int raceTime) {
        if(this.initialEnergy > this.energyBurnRate*raceTime){
            return currentSpeed*raceTime;
        }
        else{
            rest();
            return 0;
        }
    }
    @Override
    public void decelerate() {
        if(currentSpeed >= 10) currentSpeed-=10;
        else currentSpeed = 0;
        this.energyBurnRate+=5;
    }
    public void rest(){
        this.currentSpeed = 10100;
    }
}
