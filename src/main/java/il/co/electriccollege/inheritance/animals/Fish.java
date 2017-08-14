package il.co.electriccollege.inheritance.animals;

import il.co.electriccollege.inheritance.Submergeables.Submergeable;

public class Fish implements Submergeable {

    double weight;

    public Fish(double weight) {
        this.weight = weight;
    }

    public Fish() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        weight = weight;
    }

    public int timeUnderWater() {
        return 100;
    }
}
