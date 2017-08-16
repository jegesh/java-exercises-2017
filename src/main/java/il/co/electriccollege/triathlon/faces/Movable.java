package il.co.electriccollege.triathlon.faces;

/**
 * Created by yaakov on 8/16/17.
 */
public interface Movable {
    int getBaseSpeed();
    void accelerate();
    int getCurrentSpeed();
    void decelerate();
    int getTopSpeed();
}
