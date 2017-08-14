package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Noisable;

/**
 * Created by yaakov on 8/10/17.
 */
public class Car extends Vehicle implements Noisable  {

    public void makeNoise() {
        System.out.println("beep beep");
    }

    public int getVolume() {
        return 0;
    }
//from vehical


    public void revarse() {
        System.out.printf("is revaseable");
    }

    @Override
    int enginePower(String type) {
        return super.enginePower(type);
    }
}
