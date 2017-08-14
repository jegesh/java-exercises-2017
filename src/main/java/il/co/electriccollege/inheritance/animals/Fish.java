package il.co.electriccollege.inheritance.animals;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by yaakov on 8/10/17.
 */
public class Fish extends Animal implements Submergeable{
    String name;

    public Fish(String name){
        this.name = name;
    }

    public void motion() {

    }

    public void flavor() {

    }

    public void makeNoise() {

    }

    public int getVolume() {
        return 0;
    }

    @Override
    public boolean breathesAir() {
        if(this.name.equals("lungfish")){
            // a lungfish is treated as a regular animal
            return super.breathesAir();
        }
        return false;
    }

    @Override
    public boolean isUnderwater() {
        return true;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
    }
}
