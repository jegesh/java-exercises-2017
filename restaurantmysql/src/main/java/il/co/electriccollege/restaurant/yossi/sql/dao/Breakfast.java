package il.co.electriccollege.restaurant.yossi.sql.dao;

public class Breakfast extends AbstractDish{

    String eggs;

    public Breakfast(String name, String description, float price, Category category, String eggs) {
        super(name, description, price, category);
        this.eggs = eggs;
    }

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
