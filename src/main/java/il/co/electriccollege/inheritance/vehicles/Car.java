package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Noisable;

/**
 * Created by yaakov on 8/10/17.
 */
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
