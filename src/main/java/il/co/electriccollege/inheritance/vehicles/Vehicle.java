package il.co.electriccollege.inheritance.vehicles;

abstract public class Vehicle {
    public abstract void revarse();

    int enginePower(String type) {
        if (type.equals("big")) {
            return 30;

        } else if (type.equals("medium")) {
            return 20;

        } else if (type.equals("small")) {
            return 10;

        }
        return 0;
    }

}
