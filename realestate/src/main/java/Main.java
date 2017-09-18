import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbSessionManager sessionManager= new DbSessionManager(args[0]);
        SessionFactory sessionFactory= DbSessionManager.getSessionFactoryInstance();
        Session session= sessionFactory.openSession();
        session.beginTransaction();



       // asset db
//         Asset assest= new Asset();
//         assest.setAddress("Ben Gurion, 17");
//         assest.setFloor(4);
//         assest.setRooms(3);
//         assest.setYear(2006);
//         session.save(assest);

/////////////////////////////////////////////////
        //food db

        //add dish to db
//         Dish dish= new Dish();
//        dish.setName("pretty dish askdo");
//        session.save(dish);

         //modify dish
//        Dish dish= session.get(Dish.class,3);
//        dish.setName("pretty dish after update0");
//        session.saveOrUpdate(dish);
//        session.getTransaction().commit();


        //remove dish to db
//        Dish dish= session.get(Dish.class,3);
//        System.out.println(dish.getName());
//        session.delete(dish);
//        session.getTransaction().commit();


        //get a dish
    //    Dish dish= session.get(Dish.class,3);


        //get all dishes. one way
//        ArrayList<Dish> allDishes= new ArrayList<Dish>();
//        int i=1;
//        while(i<15) {
//            Dish dish = session.get(Dish.class, i);
//            if (dish != null) {
//
//                allDishes.add(dish);
//            }
//            i++;
//        }
//        for (Dish dish:allDishes)
//        {
//            System.out.println("dish info:");
//            System.out.println(String.format("name: %s",dish.getName()));
//            System.out.println("id: "+dish.getId());
//            System.out.println();
//
//        }
        //get all dishes. second way

//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Dish> criteria = builder.createQuery(Dish.class);
//        Root<Dish> root = criteria.from(Dish.class);
//        criteria.select( root );
////Select * from dish where id >0
//        criteria.where(builder.greaterThan(root.get("id"), 1);
//     //  criteria.where(builder.equal(root.get("mediaType"), "d"));
//        List<Dish> mediaList = session.createQuery( criteria ).getResultList();
//                for (Dish dish:mediaList)
//        {
//            System.out.println("dish info:");
//            System.out.println(String.format("name: %s",dish.getName()));
//            System.out.println("id: "+dish.getId());
//            System.out.println();
//
//        }


        session.close();
        try {
            sessionManager.tearDownSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
