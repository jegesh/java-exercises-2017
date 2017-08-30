package dishes;

public class StandardDish extends AbstractDish {
    private SideDish sideDish;
    private String name;
    private float price;


    public StandardDish(String name, float price, DishCatagory catagory) {
        super(name, price, catagory);
        this.name=name;
        this.price=price;
    }

    public StandardDish(int id, String name, float price, DishCatagory catagory) {
        super(id, name,price, catagory);
        this.name=name;
        this.price=price;
    }

    /**
     * adds dish to order and price of side dish to this dish's price
     * @param sideDish
     */
    public void setSideDish(SideDish sideDish){
        this.sideDish=sideDish;
    }
}
