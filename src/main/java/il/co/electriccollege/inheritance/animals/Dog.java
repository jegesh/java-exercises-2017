package il.co.electriccollege.inheritance.animals;

/**
 * Created by yaakov on 8/10/17.
 */
public class Dog extends Animal {

    public void motion() {
        System.out.println("run");
    }

    protected int energy() {
        return 0;
    }

    protected int energyBurnRate() {
        return 0;
    }

    protected int restTime() {
        return 0;
    }

    public void flavor() {
        System.out.println("gross");
    }


    public int getVolume() {
        return 40;
    }

}
