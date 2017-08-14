package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Noisable;

/**
 * Created by yaakov on 8/10/17.
 */
public class Car implements Noisable {

    public void makeNoise() {
        System.out.println("beep beep");
    }

    public int getVolume() {
        return 0;
    }
}
