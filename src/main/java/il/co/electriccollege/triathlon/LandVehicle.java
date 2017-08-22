package il.co.electriccollege.triathlon;

public class LandVehicle extends Vehicle {
    public LandVehicle(int speed, String powerEngine, int bornYear) {
        super(speed, powerEngine, bornYear);
    }

    public Vehicle crash(Vehicle v) {
        return null;
    }

    public boolean isRevarseable() {
        return false;
    }
}
