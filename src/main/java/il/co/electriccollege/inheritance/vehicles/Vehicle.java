package il.co.electriccollege.inheritance.vehicles;

/**
<<<<<<< HEAD
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

    public abstract Vehicle crash(Vehicle v);
=======
 * Created by Comp8 on 13/08/17.
 */
public abstract class Vehicle {
    public abstract void move();
    public boolean groundMoving(){
        return true;
    }
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325
}
