package il.co.electriccollege.restaurant.entitities;

import il.co.electriccollege.restaurant.dishes.AbstractDish;
import il.co.electriccollege.restaurant.dishes.DishCatagory;
import il.co.electriccollege.restaurant.dishes.SideDish;
import il.co.electriccollege.restaurant.dishes.StandardDish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager();
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


//        Dishes pizza= new Dishes();
//        pizza.setName("pizza");
//        pizza.setDescription("a vary fine pizza");
//        pizza.setPrice(30);
//        pizza.setDishCatagory(DishCatagory.SideDish);

      //   Dishes dish= session.get(Dishes.class, 4);
//        menu.setDish(dish);
//        menu.setDishName(pizza.getName());
        Menu menu=new Menu();
        menu.setHoursAvailable("07:30-10:30");
        menu.setName("breakfast menu");

        session.save(menu);

      //  session.save(soup);

        session.close();
        sessionManager.tearDownSession();
    }
}
