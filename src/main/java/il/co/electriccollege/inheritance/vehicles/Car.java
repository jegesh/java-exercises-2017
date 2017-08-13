package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Noisable;

public class Car extends Vehicle implements Noisable {


    public Car(int speed) {
        super(speed);
    }

    public void makeNoise() {
        System.out.println("beep beep");
    }

    public int getVolume() {
        return 0;
    }

    @Override
    public void move() {
        System.out.println("driving");
    }
}
