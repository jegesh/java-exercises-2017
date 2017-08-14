package il.co.electriccollege.inheritance.vehicles;

public class Car extends Vehicle {


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
}
