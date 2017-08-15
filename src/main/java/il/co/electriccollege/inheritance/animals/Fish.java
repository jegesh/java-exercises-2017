package il.co.electriccollege.inheritance.animals;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by yaakov on 8/10/17.
 */
public class Fish extends Animal implements Submergeable{
    private String name;

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

    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean isUnderwater() {
        return false;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 0;
    }
}
