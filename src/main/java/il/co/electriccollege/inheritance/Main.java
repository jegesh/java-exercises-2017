package il.co.electriccollege.inheritance;

import il.co.electriccollege.inheritance.Submergeables.Submarine;
import il.co.electriccollege.inheritance.Submergeables.Submergeable;
import il.co.electriccollege.inheritance.animals.Animal;
import il.co.electriccollege.inheritance.animals.Dog;
import il.co.electriccollege.inheritance.animals.Fish;
import il.co.electriccollege.inheritance.faces.Noisable;
import il.co.electriccollege.inheritance.faces.Submergeable;
import il.co.electriccollege.inheritance.vehicles.Car;
import il.co.electriccollege.inheritance.vehicles.Submarine;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/10/17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Noisable> noisyThings = new ArrayList<Noisable>();
        noisyThings.add(new Dog());


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
    }
}
