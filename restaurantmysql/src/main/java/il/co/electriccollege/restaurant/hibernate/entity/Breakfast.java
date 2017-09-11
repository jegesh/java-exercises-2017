package il.co.electriccollege.restaurant.hibernate.entity;


import javax.persistence.Column;

public class Breakfast extends AbstractDish {

    String eggs;

    public Breakfast(String name, String description, double price, String category, String eggs) {
        super(name, description, price, category);
        this.eggs = eggs;
    }

    @Column
    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }

    @Override
    public String toString() {
        return "Breakfast{" +
                "eggs='" + eggs + '\'' +
                "} " + super.toString();
    }
}
