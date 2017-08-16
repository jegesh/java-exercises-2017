package il.co.electriccollege.inheritance.vehicles;

/**
 * Created by Shai on 15/08/2017.
 */
public class VehicleAir extends Vehicle {

    private int startingSpeed;
    private int baseSpeed;
    private int currentSpeed;
    private int topSpeed;
    private int tankVolume;
    private int burnRate;
    private int acceleration;
    private int deceleration;

    //constructors


    public VehicleAir(int startingSpeed, int baseSpeed, int currentSpeed,
                       int topSpeed, int tankVolume, int burnRate, int acceleration, int deceleration) {
        this.startingSpeed = startingSpeed;
        this.baseSpeed = baseSpeed;
        this.currentSpeed = currentSpeed;
        this.topSpeed = topSpeed;
        this.tankVolume = tankVolume;
        this.burnRate = burnRate;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
    }

    public VehicleAir() {
        this.startingSpeed = 0;
        this.baseSpeed = 0;
        this.currentSpeed = 0;
        this.topSpeed = 100;
        this.tankVolume = 100;
        this.burnRate = 5;
        this.acceleration = 20;
        this.deceleration = 20;
    }
    // Movable Methods
    public int move() {
        return 0;
    }

    //Vehicle Methods

    @Override
    public int getBaseSpeed() {
        return super.getBaseSpeed();
    }

    @Override
    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    @Override
    public int getTopSpeed() {
        return this.topSpeed;
    }

    @Override
    public void acceleration() {
        this.currentSpeed+=20;
    }

    @Override
    public void deceleration() {
        this.currentSpeed-=20;
    }

    @Override
    protected int getTankVolume() {
        return this.tankVolume;
    }

    @Override
    protected int gasBurnRate() {
        return this.burnRate;
    }

    //getters & setters


    public int getStartingSpeed() {
        return startingSpeed;
    }

    public void setStartingSpeed(int startingSpeed) {
        this.startingSpeed = startingSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public int getBurnRate() {
        return burnRate;
    }

    public void setBurnRate(int burnRate) {
        this.burnRate = burnRate;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getDeceleration() {
        return deceleration;
    }

    public void setDeceleration(int deceleration) {
        this.deceleration = deceleration;
    }
}
