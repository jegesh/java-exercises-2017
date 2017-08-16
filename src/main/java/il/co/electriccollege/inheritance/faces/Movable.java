package il.co.electriccollege.inheritance.faces;

/**
 * Created by Shai on 15/08/2017.
 */
public interface Movable {

    public  int move();
    public  int getBaseSpeed();
    public  int getCurrentSpeed();
    public  int getTopSpeed();
    public  void acceleration();
    public  void deceleration();
}
