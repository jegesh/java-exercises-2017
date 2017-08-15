package il.co.electriccollege.inheritance.vehicles;
import il.co.electriccollege.inheritance.faces.Submergeable;

/**
<<<<<<< HEAD
 * Created by yaakov on 8/14/17.
 */
public class Submarine extends Vehicle implements Submergeable {

    public Submarine(int speed) {
        super(speed);
    }

    @Override
    public boolean isUnderwater() {
        return speed > 20;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 24 * 60;
    }

    @Override
    public String getMedium() {
        return "water";
    }

    @Override
    public Vehicle crash(Vehicle v) {
        return v;
=======
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
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325
    }
}
