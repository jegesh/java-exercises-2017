package il.co.electriccollege.triathlon.animals;

import il.co.electriccollege.triathlon.faces.Submergeable;

/**
 * Created by IrKha on 14.08.2017.
 */
public class Fish extends Animal implements Submergeable {
    private int maxTimeUnderwater;

    public Fish(int baseSpeed, int topSpeed, int initialEnergy, int energyBurnRate) throws SpeedException {
        super();
        this.initialEnergy = initialEnergy;
        this.energyBurnRate = energyBurnRate;
        this.baseSpeed = baseSpeed;
        if (baseSpeed > topSpeed) {
            int cProposal = baseSpeed;
            throw new SpeedException("Base speed have to be higher than topSpeed", cProposal);
        } else {
            this.topSpeed = topSpeed;
        }
    }
    @Override
    public boolean canSwim() {
        return true;
    }

    @Override
    public int getMaxTimeUnderwater() {
        return maxTimeUnderwater;
    }
    public void setMaxTimeUnderwater(int maxTimeUnderwater){
        this.maxTimeUnderwater = maxTimeUnderwater;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "initialEnergy=" + initialEnergy +
                ", energyBurnRate=" + energyBurnRate +
                ", baseSpeed=" + baseSpeed +
                ", currentSpeed=" + currentSpeed +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
