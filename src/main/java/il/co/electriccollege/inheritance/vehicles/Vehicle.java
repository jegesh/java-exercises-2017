package il.co.electriccollege.inheritance.vehicles;

public  abstract class Vehicle
{
    private int fuelTank;
    private float FuelConsumption;


    public int getFuelTank() {
        return fuelTank;
    }

    public float getFuelConsumption() {
        return FuelConsumption;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public void setFuelConsumption(float fuelConsumption) {
        FuelConsumption = fuelConsumption;
    }

    public float MaximumDrivingDistance (int fuelTank, float FuelConsumption)
    {
        return fuelTank*FuelConsumption;
    }

    public  abstract void WhereVehiclesWork();

}
