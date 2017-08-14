package il.co.electriccollege.inheritance.Submergeables;

import il.co.electriccollege.inheritance.vehicles.Vehicle;

public class Submarine extends Vehicle implements Submergeable
{

    String color;

    public Submarine(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void WhereVehiclesWork() {
        System.out.printf("Under water");
    }

    @Override
    public int timeUnderWater() {
        return 24;
    }
}
