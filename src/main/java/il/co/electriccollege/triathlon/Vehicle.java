package il.co.electriccollege.triathlon;


public abstract class Vehicle {
    protected int speed;
    protected String powerEngine;
    int bornYear;

//CONSTRACTORS

    public Vehicle(int speed, String powerEngine, int bornYear) {
        this.speed = speed;
        this.powerEngine = powerEngine;
        this.bornYear = bornYear;
    }


//GET&SET

    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed Betweeb 0-250
     */
    public void setSpeed(int speed) {
        if (speed < 251 && speed>-1)
            this.speed = speed;
        else System.out.println("Speed does not make sense");
    }

    public String getPowerEngine() {
        return powerEngine;
    }

    /**
     * @param powerEngine Levels: low,medium,big
     */
    public void setPowerEngine(String powerEngine) {
        if (powerEngine.equals("low") || powerEngine.equals("medium") || powerEngine.equals("big"))
            this.powerEngine = powerEngine;
        else
            System.out.println("Wrong input, plaese enter valid power level: low/medium/big");
    }

    public int getBornYear() {
        return bornYear;
    }

    /**
     * @param bornYear Up then 2000
     */
    public void setBornYear(int bornYear) {
        if (bornYear > 1999)
            this.bornYear = bornYear;
        else
            System.out.println("Wrong input, plaese enter valid born year: up then 2,000");
    }

    //METHODS

    public void speedUp() {
        speed += 10;
    }

    public void speedDown() {
        speed -= 10;
    }

    //ABSTRACTS METHODS

    public abstract Vehicle crash(Vehicle v);

    public abstract boolean isRevarseable();
}
