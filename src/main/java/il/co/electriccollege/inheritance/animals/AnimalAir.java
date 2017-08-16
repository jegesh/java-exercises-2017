package il.co.electriccollege.inheritance.animals;

/**
 * Created by Shai on 16/08/2017.
 */
public class AnimalAir extends Animal {

    private  int motion;
    private int baseSpeed;
    private int currentSpeed;
    private int topSpeed;
    private int energy;
    private int energyBurnRate;
    private int acceleration;
    private int deceleration;
    private int restTime;
    // constructors

    public AnimalAir(int motion, int baseSpeed, int currentSpeed,
                     int topSpeed, int energy, int energyBurnRate,
                     int acceleration, int deceleration, int restTime) {
        this.motion = motion;
        this.baseSpeed = baseSpeed;
        this.currentSpeed = currentSpeed;
        this.topSpeed = topSpeed;
        this.energy = energy;
        this.energyBurnRate = energyBurnRate;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.restTime = restTime;
    }

    public AnimalAir() {
        this.motion = 0;
        this.baseSpeed = 0;
        this.currentSpeed = 0;
        this.topSpeed = 100;
        this.energy = 100;
        this.energyBurnRate = 5;
        this.acceleration = 5;
        this.deceleration = 5;
        this.restTime = restTime();
    }

    // Animal
    protected void motion() {

    }

    //Animal Air

    @Override
    public int getBaseSpeed() {
        return super.getBaseSpeed();
    }

    @Override
    public int move() {
        return this.move();
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
        this.acceleration();
    }

    @Override
    public void deceleration() {
        this.deceleration();
    }

    @Override
    protected boolean breathesAir() {
        return super.breathesAir();
    }

    @Override
    protected int energy() {
        return super.energy();
    }

    @Override
    protected int energyBurnRate() {
        return this.energyBurnRate();
    }

    @Override
    protected int restTime() {
        return this.energy/this.energyBurnRate;
    }
    //getters and setters


    public int getMotion() {
        return motion;
    }

    public void setMotion(int motion) {
        this.motion = motion;
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergyBurnRate() {
        return energyBurnRate;
    }

    public void setEnergyBurnRate(int energyBurnRate) {
        this.energyBurnRate = energyBurnRate;
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

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
