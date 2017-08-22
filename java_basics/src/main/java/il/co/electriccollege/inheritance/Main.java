package il.co.electriccollege.inheritance;

<<<<<<< HEAD
import il.co.electriccollege.inheritance.Submergeables.Submarine;
import il.co.electriccollege.inheritance.Submergeables.Submergeable;
=======
import com.sun.corba.se.impl.io.TypeMismatchException;
>>>>>>> master
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
<<<<<<< HEAD

=======
        noisyThings.add(new Car(10));
>>>>>>> master

        for(Noisable n: noisyThings){
            n.makeNoise();



            ArrayList<Submergeable> sub = new ArrayList<Submergeable>();

            Fish sardine = new Fish(0.3);
            sub.add(sardine);
            Submarine s123 = new Submarine("blue");
            sub.add(s123);

            for ( int i=0; i< sub.size() ; i++)
            {
                System.out.println(""+(sub.get(i).timeUnderWater()));
            }
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
        }

<<<<<<< HEAD:src/main/java/il/co/electriccollege/inheritance/Main.java
        // polymorphism
        Car c = new Car(10);
        Submarine sb = new Submarine(20);
=======

        Vehicle c = new Car(5);
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

        // polymorphism
        Vehicle c2 = new Car(10);
        Submarine sb = new Submarine("k");
>>>>>>> e24927ac100b36fa506e937983e8ce80f28375b3:java_basics/src/main/java/il/co/electriccollege/inheritance/Main.java
        Vehicle v = c.crash(sb);
        System.out.println(v instanceof Submarine);

        try {
            Submergeable submergeable = sb;
        }catch (TypeMismatchException ex){
            // do something
        }


    }
}
