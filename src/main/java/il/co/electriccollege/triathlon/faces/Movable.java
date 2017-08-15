package il.co.electriccollege.triathlon.faces;

/**
 * Created by IrKha on 14.08.2017.
 */
public interface Movable {
    public int move();
    public int getBaseSpeed();
    public void accelerate();
    public int getCurrentSpeed();
    public void decelerate();
    public int getTopSpeed();
}
