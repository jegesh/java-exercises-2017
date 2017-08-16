package il.co.electriccollege.triathlon.faces;

/**
 * Created by yaakov on 8/16/17.
 */
public abstract class Movable {
    private int speed;
    private int rateOfAcceleration;
    protected int distance;

    public Movable(int speed, int rateOfAcceleration){
        this.speed = speed;
        this.rateOfAcceleration = rateOfAcceleration;
    }

    public int getDistance(){ return distance; }

    public void accelerate(){
        int tempSpeed = speed + rateOfAcceleration;
        if(tempSpeed <= getTopSpeed())
            speed = tempSpeed;
        else
            speed = getTopSpeed();
    };

    public int getCurrentSpeed(){
        return speed;
    };

    public void decelerate(){
        int tempSpeed = speed - rateOfAcceleration;
        if(tempSpeed > 0)
            speed = tempSpeed;
        else
            speed = 0;
    };

    protected void setSpeed(int speed){
        this.speed = speed;
    }

    /**
     * to be called once a turn
     */
    public abstract void move();

    public abstract int getTopSpeed();
}
