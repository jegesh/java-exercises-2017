package il.co.electriccollege.triathlon;

import il.co.electriccollege.inheritance.faces.Noisable;

/**
 * Created by yaakov on 8/10/17.
 */
public abstract class Animal implements Noisable{

    public abstract void motion();

    public abstract void flavor();

    public abstract void makeNoise();

    public boolean breathesAir(){
        return true;
    }

    public abstract int getVolume();
}
