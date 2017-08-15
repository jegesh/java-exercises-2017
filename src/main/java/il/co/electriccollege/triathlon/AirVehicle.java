package il.co.electriccollege.triathlon;

public class AirVehicle extends Vehicle {
    public AirVehicle(int speed, String powerEngine, int bornYear) {
        super(speed, powerEngine, bornYear);
    }

    public Vehicle crash(Vehicle v) {
        return null;
    }

    public boolean isRevarseable() {
        return false;
    }
}
