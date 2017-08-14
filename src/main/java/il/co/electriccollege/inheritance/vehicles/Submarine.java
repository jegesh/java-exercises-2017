package il.co.electriccollege.inheritance.vehicles;

import il.co.electriccollege.inheritance.faces.Submergeable;

/**
 * Created by Comp8 on 13/08/17.
 */
public class Submarine extends Vehicle implements Submergeable{

    private String name;

    public Submarine(String name){
        this.name = name;
    }

    public void move() {
        System.out.println("i can move too");
    }

    @Override
    public boolean groundMoving(){
        System.out.println("i can't move on the ground");
        return false;
    }

    public void goUnderWater() {
        System.out.println("i cam go underwater");
    }

    @Override
    public String toString() {
        return "Submarine{" +
                "name='" + name + '\'' +
                '}';
    }
}
