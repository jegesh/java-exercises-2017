import SQL.DatabaseConnector;
import SQL.RestaurantDal;
import dishes.DishCatagory;
import dishes.SideDish;

public class DBMain {

    public static void main(String[] args)
    {
       // DatabaseConnector databaseConnector= new DatabaseConnector();
        RestaurantDal dal=new RestaurantDal(new DatabaseConnector());
      //  dal.getAllDishes();
     //   dal.getTenCheapestDishes();
  //      dal.getDishesByCategory(DishCatagory.SideDish);

          SideDish  pizza = new SideDish(1,"pizza", 10, DishCatagory.SideDish);
        //  SideDish soup= new SideDish(2,"soup", 15, DishCatagory.SideDish);


      //    dal.addDish(soup); // working
     //   dal.removeDish(soup);  //working
       // dal.updatePrice(pizza,5);
    }

}
