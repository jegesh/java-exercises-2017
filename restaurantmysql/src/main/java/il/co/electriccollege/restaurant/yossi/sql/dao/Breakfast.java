package il.co.electriccollege.restaurant.yossi.sql.dao;

public class Breakfast extends AbstractDish{

    String egg;
    String drink;

    public Breakfast(String name, String description, float price, String category, String egg, String drink) {
        super(name, description, price, category);
        this.egg = egg;
        this.drink = drink;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Breakfast{" +
                "egg='" + egg + '\'' +
                ", drink='" + drink + '\'' +
                "} " + super.toString();
    }
}
