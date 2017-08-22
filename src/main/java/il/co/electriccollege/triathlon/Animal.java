package il.co.electriccollege.triathlon;

/**
 * Created by tzur on 8/15/17.
 */
public abstract class Animal {

 private int age;
 private int timeWithoutAir;
 private int numOfLegs;

//CONSTRACTORS

    public Animal(int age, int timeWithoutAir, int numOfLegs) {
        this.age = age;
        this.timeWithoutAir = timeWithoutAir;
        this.numOfLegs = numOfLegs;
    }

//SET&GET

    public int getAge() {
        return age;
    }

    /**
     *
     * @param age Between 0-100 year old
     */
    public void setAge(int age) {
        if(age<101 &&age>-1)
            this.age = age;
        else
            System.out.println("Wrong input, plaese enter valid age: 0-100 year old");
    }

    public int getTimeWithoutAir() {
        return timeWithoutAir;
    }

    /**
     *
     * @param timeWithoutAir Between 0-24 Hour a day
     */
    public void setTimeWithoutAir(int timeWithoutAir) {
        if(timeWithoutAir<25 &&timeWithoutAir>-1)
            this.timeWithoutAir = timeWithoutAir;
        else
            System.out.println("Wrong input, plaese enter valid time without air: 0-24 hours a day");

    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    /**
     *
     * @param numOfLegs Between 0-4 legs
     */
    public void setNumOfLegs(int numOfLegs) {
        if(numOfLegs<5 &&numOfLegs>-1)
            this.numOfLegs = numOfLegs;
        else
            System.out.println("Wrong input, plaese enter valid number of legs: 0-4");
    }

//METHODS
    public abstract void motion();


    public abstract void makeNoise();


    public abstract int getNoiseVolume();
}
