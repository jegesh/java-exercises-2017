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

import java.lang.reflect.Method;
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


<<<<<<< HEAD
        ArrayList<Submergeable> submergeables = new ArrayList<>();
        Submarine sub = new Submarine(10);
        boolean isUnderwater = sub.isUnderwater();
        sub.speedUp();
        boolean isUnderwaterNow = sub.isUnderwater();
        submergeables.add(sub);
        submergeables.add(new Fish("Amnon"));

        for(Submergeable s: submergeables){
            System.out.println(s.getMaxTimeUnderwater());
=======
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
>>>>>>> b3004a70821b5c89e596dd59bdf37882b168f325
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
