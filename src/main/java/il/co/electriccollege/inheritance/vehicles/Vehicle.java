package il.co.electriccollege.inheritance.vehicles;

/**
 * Created by yaakov on 8/14/17.
 */
public abstract class Vehicle {
    protected int speed;

    public Vehicle(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void speedUp(){
        speed += 10;
    }

    public abstract String getMedium();
}
