package il.co.electriccollege.inheritance.vehicles;
import il.co.electriccollege.inheritance.faces.Submergeable;

public class Submarine extends Vehicle implements Submergeable{
    private String name;

    public Submarine(String name){
        super(1);
        this.name = name;
    }

    public void move() {
        System.out.println("i can move too");
    }

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

    public boolean isUnderwater() {
        return false;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return 0;
    }

    @Override
    public String getMedium() {
        return null;
    }

    @Override
    public Vehicle crash(Vehicle v) {
        return null;
    }
}
