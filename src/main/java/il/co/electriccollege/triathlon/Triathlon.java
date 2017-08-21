package il.co.electriccollege.triathlon;

import il.co.electriccollege.triathlon.animals.Bird;
import il.co.electriccollege.triathlon.animals.Dog;
import il.co.electriccollege.triathlon.animals.SpeedException;

/**
 * Created by yaakov on 8/14/17.
 */
public class Triathlon {
    public static void main(String[] args) throws SpeedException {
        Dog d = new Dog(10, 15, 20, 20);
        Bird b = new Bird(20,50,2,10);
        System.out.println(d);
        d.setInitialEnergy(100);
        System.out.println(b);
    }
}
