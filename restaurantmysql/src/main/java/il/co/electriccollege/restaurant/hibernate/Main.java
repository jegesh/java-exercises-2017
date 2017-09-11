package il.co.electriccollege.restaurant.hibernate;

import il.co.electriccollege.restaurant.hibernate.entity.AbstractDish;
import il.co.electriccollege.restaurant.hibernate.entity.Breakfast;
import il.co.electriccollege.restaurant.hibernate.entity.Category;
import il.co.electriccollege.restaurant.hibernate.entity.Pasta;
import il.co.electriccollege.restaurant.hibernate.DbSessionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static il.co.electriccollege.restaurant.hibernate.entity.Category.BREAKFAST;


/**
 * Created by yaakov on 8/28/17.
 */
public class Main {



        public static void main (String[]args) throws Exception {

            DbSessionManager sessionManager = new DbSessionManager();
            SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // add dish
            AbstractDish dish = new AbstractDish();
            dish.setName("yami");
            dish.setDescription("very good one");
            dish.setPrice(55.30);
            dish.setCategory(Category.BREAKFAST.name());
            session.save(dish);

            // get single dish
            AbstractDish dish2 = session.get(AbstractDish.class, 1);


            // modify dish
            System.out.println(dish2.getCategory());
            dish2.setCategory(Category.BREAKFAST.name());
            String formerDesc = dish.getDescription();
            try {
                session.saveOrUpdate(dish2);
                session.getTransaction().commit();
                session.beginTransaction();
                dish.setDescription("aflkjsdfkl; sad;fj asl;kdfl sadjfkl;asdj fklsdj;fladslfkjsdf adsklfjas;dlfj l;aksdjf;lkasdjfkl;asdjf;lkajsd;fkl ajsdkf jasodipjfpoiwejfpqoiadvoksdiocajdiofjapoisdjf pasdjfiopsjd f");
                session.saveOrUpdate(dish);

                session.getTransaction().commit();
            }catch (Exception ex){
                // rollback objects
                ex.printStackTrace();
                dish.setDescription(formerDesc);
            }

            // without transaction, delete does nothing
            session.delete(dish);

            System.out.println(dish2.getCategory());
            session.close();
            sessionManager.tearDownSession();
        }


}
