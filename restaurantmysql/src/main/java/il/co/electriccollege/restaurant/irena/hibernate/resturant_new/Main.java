package il.co.electriccollege.restaurant.irena.hibernate.resturant_new;


import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.DbSessionManager;
import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao.*;
import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao.enums.CategoryEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Comp8 on 04/09/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager(args[0]);
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Menu menu = new Menu();
        menu.setHours_available("12-19");
        menu.setName("buiseness menu");
        Menu menu2 = new Menu();
        menu2.setHours_available("13-19");
        menu2.setName("buiseness menu");

        Dish grill = new Dish();
        grill.setDescription("grill bar");
        grill.setPrice(20);
        grill.setName("big burger from romania");
        grill.setCategory(CategoryEnum.Grill);
        //session.save(menu2);
        grill.setMenu(menu2);
        session.saveOrUpdate(grill);
        session.close();
        sessionManager.tearDownSession();
    }

}
