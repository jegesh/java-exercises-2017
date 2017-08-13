package il.co.electriccollege.inheritance.vehicles;

/**
 * Created by borka on 8/12/2017.
 */
 public abstract class Vehicle {
    private int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public abstract void move();

    public int increaseSpeed (int currSpeed)
    {
        speed = speed+10;
        return speed;
    }

}
