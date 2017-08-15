package il.co.electriccollege.triathlon.animals;
import il.co.electriccollege.triathlon.faces.*;


/**
 * Created by IrKha on 14.08.2017.
 */
public abstract class Animal implements Movable {

    protected int initialEnergy;
    protected int energyBurnRate;

   /* public void rest(int raceTime){
        if(energyBurnRate*raceTime < initialEnergy)return;
    }*/
    public abstract void rest();
    public void setInitialEnergy(int initialEnergy){
        this.initialEnergy = initialEnergy;
    }
    public void setEnergyBurnRate(int energyBurnRate){
        this.energyBurnRate = energyBurnRate;
    }
}
