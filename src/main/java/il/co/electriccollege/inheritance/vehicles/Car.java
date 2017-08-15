package il.co.electriccollege.inheritance.vehicles;

public class Car extends Vehicle {

<<<<<<< HEAD
=======
/**
 * Created by yaakov on 8/10/17.
 */
public class Car extends Vehicle implements Noisable {

    public Car(int speed) {
        super(speed);
    }
>>>>>>> master

private int numberOfRoll;


public void setNumberOfRoll ( int numberOfRoll)
{
    this.numberOfRoll = numberOfRoll;
}
public int getNumberOfRoll ()
{
    return this.numberOfRoll;
}
    @Override
    public void WhereVehiclesWork() {
        System.out.printf("land");
    }

    @Override
    public String getMedium() {
        return "ground";
    }

    @Override
    public Vehicle crash(Vehicle v) {
        v.setSpeed(0);
        this.setSpeed(0);
        return v;
    }
}
