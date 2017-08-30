package il.co.electriccollege.restaurant.yossi.sql.dao;

public class Pasta extends AbstractDish{

    String typeOfPasta;
    String sauce;

    public Pasta(String name, String description, float price, String category, String typeOfPasta, String sauce) {
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
