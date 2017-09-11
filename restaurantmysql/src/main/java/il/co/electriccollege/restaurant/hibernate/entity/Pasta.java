package il.co.electriccollege.restaurant.hibernate.entity;

public class Pasta extends AbstractDish {


    String typeOfPasta;
    public String sauce;

    public Pasta(String name, String description, double price, String category, String typeOfPasta, String sauce) {
        super(name, description, price, category);
        this.typeOfPasta = typeOfPasta;
        this.sauce = sauce;
    }

    public String getTypeOfPasta() {
        return typeOfPasta;
    }

    public void setTypeOfPasta(String typeOfPasta) {
        this.typeOfPasta = typeOfPasta;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Pasta{" +
                "typeOfPasta='" + typeOfPasta + '\'' +
                ", sauce='" + sauce + '\'' +
                "} " + super.toString();
    }
}
