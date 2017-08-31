package il.co.electriccollege.restaurant.tzur;


import il.co.electriccollege.restaurant.tzur.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.tzur.sql.dal.MenuDal;
import il.co.electriccollege.restaurant.tzur.sql.dao.DessertDish;
import il.co.electriccollege.restaurant.tzur.sql.dao.Dish;
import il.co.electriccollege.restaurant.tzur.sql.dao.FirstDish;
import il.co.electriccollege.restaurant.tzur.sql.dao.MainDish;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {
        MenuDal myMenu = new MenuDal(new DatabaseConnector());
        FirstDish myFirstDish = new FirstDish("סלט בריאות", "טבעוני", 15.5F, true);
        MainDish myMainDish = new MainDish("סטייק", "300 גרם, עם תוספת אחת", 70, 8);
        DessertDish mydessertDish = new DessertDish("עוגה", "3 שכבות", 30, 7);
//        tests

//        add
//        myMenu.addDishToMenu(myFirstDish);
//        myMenu.addDishToMenu(myMainDish);
//        myMenu.addDishToMenu(mydessertDish);

//        query
//        Dish testDish = myMenu.getById(3);
//        System.out.println(testDish);

//        update/delete
//        Dish testDish = new Dish();
//        testDish.setDishId(4);
//        myMenu.removeDish(testDish);


    }
}
