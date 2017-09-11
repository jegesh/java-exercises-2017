package il.co.electriccollege.restaurant.dishes;

public class SideDish extends AbstractDish {

    private String name;
   private  float price;


    public SideDish(String name, float price,  DishCatagory catagory)
    {
        super(name, price, catagory);
        this.name=name;
        this.price=price;
    }

    public SideDish(int id, String name, float price, DishCatagory catagory) {
        super(id, name,price, catagory);
        this.name=name;
        this.price=price;
    }

//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public float getPrice() {
//        return price;
//    }
//
//    @Override
//    public void setPrice(float price) {
//        this.price = price;
//    }


}
