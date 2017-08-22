package il.co.electriccollege.triathlon.animals;
import il.co.electriccollege.triathlon.faces.Flyable;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Bird extends Animal implements Flyable{

    public Bird(int baseSpeed, int topSpeed, int initialEnergy, int energyBurnRate) throws SpeedException {
        super();
        this.initialEnergy = initialEnergy;
        this.energyBurnRate = energyBurnRate;
        this.baseSpeed = baseSpeed;
        if(baseSpeed > topSpeed){
            int cProposal =  baseSpeed;
            throw new SpeedException("Base speed have to be higher than topSpeed", cProposal);
        }else{
            this.topSpeed = topSpeed;
        }
    }
    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "initialEnergy=" + initialEnergy +
                ", energyBurnRate=" + energyBurnRate +
                ", baseSpeed=" + baseSpeed +
                ", currentSpeed=" + currentSpeed +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
