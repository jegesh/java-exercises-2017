package il.co.electriccollege.inheritance;

import il.co.electriccollege.inheritance.animals.Animal;
import il.co.electriccollege.inheritance.animals.Dog;
import il.co.electriccollege.inheritance.animals.Fish;
import il.co.electriccollege.inheritance.faces.Noisable;
import il.co.electriccollege.inheritance.faces.Submergeable;
import il.co.electriccollege.inheritance.vehicles.Car;
import il.co.electriccollege.inheritance.vehicles.Submarine;
import il.co.electriccollege.inheritance.vehicles.Vehicle;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by yaakov on 8/10/17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Noisable> noisyThings = new ArrayList<Noisable>();
        noisyThings.add(new Dog());
        noisyThings.add(new Car());

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


        // well known use case
        Runnable myRunnable = new Runnable() {
            public void run() {
                // check weather
            }
        };

        System.out.println("---------Underwater things------------");
        ArrayList<Submergeable> subs = new ArrayList<Submergeable>();
        subs.add(new Fish("Nemo"));
        subs.add(new Submarine("Yellow submarine"));

        for(Submergeable s: subs){
            System.out.print(s+" - ");
            s.goUnderWater();
        }


        Vehicle c = new Car();
        System.out.println(c);
       // Car c2 = (Car) c;
        //System.out.println(c2);
        Class cl = c.getClass();
        System.out.println(cl);
        System.out.println(cl.getTypeParameters());

        System.out.println(c instanceof Object);

        System.out.println(cl.getSuperclass());
        Method[] m = cl.getSuperclass().getDeclaredMethods();
        for(int i = 0; i < 10; i++){
            System.out.println(m[i]);
        }
    }
}
