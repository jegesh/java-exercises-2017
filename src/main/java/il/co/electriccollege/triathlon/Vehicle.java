package il.co.electriccollege.triathlon;


public abstract class Vehicle {
    protected int speed;
    protected String powerEngine;

    //CONSTRACTORS

    public Vehicle(int speed, String powerEngine) {
        this.speed = speed;
        this.powerEngine = powerEngine;
    }

    //GET&SET

    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed Betweeb 0-250
     */
    public void setSpeed(int speed) {
        if (speed < 251)
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

    //METHODS

    public void speedUp() {
        speed += 10;
    }

    public void speedDown() {
        speed -= 10;
    }

    public abstract Vehicle crash(Vehicle v);
}
