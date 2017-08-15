package il.co.electriccollege.triathlon;

public class AirAnimal extends Animal {
    public AirAnimal(int age, int timeWithoutAir, int numOfLegs) {
        super(age, timeWithoutAir, numOfLegs);
    }

    public void motion() {

    }

    public void makeNoise() {

    }

    public int getNoiseVolume() {
        return 0;
    }
}
