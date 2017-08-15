package il.co.electriccollege.inheritance;

import com.sun.corba.se.impl.io.TypeMismatchException;
import il.co.electriccollege.inheritance.animals.Animal;
import il.co.electriccollege.inheritance.animals.Dog;
import il.co.electriccollege.inheritance.animals.Fish;
import il.co.electriccollege.inheritance.faces.Noisable;
import il.co.electriccollege.inheritance.faces.Submergeable;
import il.co.electriccollege.inheritance.vehicles.Car;
import il.co.electriccollege.inheritance.vehicles.Submarine;
import il.co.electriccollege.inheritance.vehicles.Vehicle;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/10/17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Noisable> noisyThings = new ArrayList<Noisable>();
        noisyThings.add(new Dog());
        noisyThings.add(new Car(10));

        for(Noisable n: noisyThings){
            n.makeNoise();
        }

        // anonymous class
        Noisable motorcycle = new Noisable() {

            public void makeNoise() {
                System.out.println("random sound");
            }

            public int getVolume() {
                return 50;
            }
        };

        // anonymous subclass
        Animal giraffe = new Animal(){
            private String texture = "fuzzy";

            public String getFurTexture(){
                return texture;
            }

            @Override
            public void makeNoise() {
                System.out.println("munch");
            }

            public int getVolume() {
                return 20;
            }

            @Override
            public void motion() {
                System.out.println("walk");
            }

            public void flavor() {
                System.out.println("yummy");
            }
        };


        ArrayList<Submergeable> submergeables = new ArrayList<>();
        Submarine sub = new Submarine(10);
        boolean isUnderwater = sub.isUnderwater();
        sub.speedUp();
        boolean isUnderwaterNow = sub.isUnderwater();
        submergeables.add(sub);
        submergeables.add(new Fish("Amnon"));

        for(Submergeable s: submergeables){
            System.out.println(s.getMaxTimeUnderwater());
        }

        // polymorphism
        Car c = new Car(10);
        Submarine sb = new Submarine(20);
        Vehicle v = c.crash(sb);
        System.out.println(v instanceof Submarine);

        try {
            Submergeable submergeable = sb;
        }catch (TypeMismatchException ex){
            // do something
        }


    }
}
