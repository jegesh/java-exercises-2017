package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

public class Submarine extends Vehicle implements Submergeable {

    int ep = enginePower("big");

    @Override
    public String toString() {
        return "Submarine{" +
                "enginePower=" + ep +
                '}';
    }

    public boolean swimming() {
        return false;
    }

    public boolean breathAir() {
        return true;
    }

    public void revarse() {
        System.out.printf("is not revaseable");
    }
}
