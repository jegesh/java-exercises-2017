package il.co.electriccollege.restaurant.hibernate.entity;

public class Sandwiches extends AbstractDish {

    String breadType;
    String sizeOfSandwich;

    public Sandwiches(String name, String description, double price, String category, String breadType, String sizeOfSandwich) {
        super(name, description, price, category);
        this.breadType = breadType;
        this.sizeOfSandwich = sizeOfSandwich;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSizeOfSandwich() {
        return sizeOfSandwich;
    }

    public void setSizeOfSandwich(String sizeOfSandwich) {
        this.sizeOfSandwich = sizeOfSandwich;
    }

    @Override
    public String toString() {
        return "Sandwiches{" +
                "breadType='" + breadType + '\'' +
                ", sizeOfSandwich='" + sizeOfSandwich + '\'' +
                "} " + super.toString();
    }
}
