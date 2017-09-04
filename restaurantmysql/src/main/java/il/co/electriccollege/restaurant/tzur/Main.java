package il.co.electriccollege.restaurant.tzur;


import il.co.electriccollege.restaurant.tzur.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.tzur.sql.dal.MenuDal;
import il.co.electriccollege.restaurant.tzur.sql.dao.DessertDish;
import il.co.electriccollege.restaurant.tzur.sql.dao.Dish;
import il.co.electriccollege.restaurant.tzur.sql.dao.FirstDish;
import il.co.electriccollege.restaurant.tzur.sql.dao.MainDish;
import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager();
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Dish hiberTest = new Dish();
        hiberTest.setDescription("hiberTest");
        hiberTest.setName("hiberTest");
        hiberTest.setPrice(100);

        session.save(hiberTest);
        session.close();
        sessionManager.tearDownSession();



//        MenuDal myMenu = new MenuDal(new DatabaseConnector());
//        ***tests***

//        ***clean Table***
//        myMenu.cleanTable();
//        ***add***
//        for (int i = 1; i < 5; i++) {
//            FirstDish myFirstDish = new FirstDish("סלט בריאות" + i, "טבעוני", 0 + i, true);
//            MainDish myMainDish = new MainDish("סטייק" + i, "300 גרם, עם תוספת אחת", 3 + i, 8);
//            DessertDish mydessertDish = new DessertDish("עוגה" + i, "3 שכבות", 10 + i, 7);
//
//            myMenu.addDishToMenu(myFirstDish);
//            myMenu.addDishToMenu(myMainDish);
//            myMenu.addDishToMenu(mydessertDish);
//        }
//

//        ***query***
//        Dish testDish = myMenu.getById(3);
//        System.out.println(testDish);

//        ***update/delete***
//        Dish testDish = new Dish();
//        testDish.setDishId(4);
//        myMenu.removeDish(testDish);

//        ***custom methods***
//        ArrayList<Dish> dishArrayList = new ArrayList<>();
//        dishArrayList=myMenu.getAllDishes();

//        dishArrayList=myMenu.getTenCheapestDishes();

//        dishArrayList = myMenu.getDishesByCategory(Category.DESSERT);
//        System.out.println(dishArrayList.get(0));

//        myMenu.updatePrice(dishArrayList.get(0), 20);
//        dishArrayList = myMenu.getDishesByCategory(Category.DESSERT);
//        System.out.println(dishArrayList.get(0));


    }
}
