package il.co.electriccollege.inheritance.animals;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by yaakov on 8/10/17.
 */
public class Fish extends Animal implements Submergeable{
<<<<<<< HEAD
    String name;
=======
    private String name;
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325

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
<<<<<<< HEAD
    public boolean isUnderwater() {
        return true;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return Integer.MAX_VALUE;
    }

    @Override
=======
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
<<<<<<< HEAD
=======
    }


    public void goUnderWater() {
        System.out.println("i can swim underwater");
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325
    }
}
