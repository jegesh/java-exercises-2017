package il.co.electriccollege.realestate;


import il.co.electriccollege.realestate.entity.Property;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by yaakov on 9/18/17.
 */
public class Main {

    public static void main(String[] args) {

        // example of inserting new object to database from code
        DbSessionManager sessionManager = new DbSessionManager();

        Property property = new Property();
        property.setAddress("5 HaShalom, Hadera");
        property.setFloor(11);
        property.setName("Electric College ");
        property.setNumOfRooms(15);
        property.setYard(100);

        Session session = sessionManager.getSessionFactoryInstance().openSession();
        session.save(property);
        session.close();

        // example of object retrieval


        Session session1 = sessionManager.getSessionFactoryInstance().openSession();
        Property property1 = session1.get(Property.class, property.getId());
        session1.close();

        // example of object update

        Session session2 = sessionManager.getSessionFactoryInstance().openSession();
        session2.beginTransaction();
        property1.setYard(1);
        session2.update(property1);
        session2.getTransaction().commit();
        session2.close();

        System.out.println("Property has yard: " + property.getYard());
        System.out.println("Property1 has yard: " + property1.getYard());
        System.out.println("=====================");

        // example of refreshing object from database

        Session session3 = sessionManager.getSessionFactoryInstance().openSession();
        session3.refresh(property);
        session3.close();

        System.out.println("Property1 has yard: " + property1.getYard());
        System.out.println("Property1 has yard: " + property1.getYard());

        // example of retrieving a list of objects

        Session session4 = sessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Property> criteria = builder.createQuery(Property.class);
        Root<Property> root = criteria.from(Property.class);
        criteria.where(builder.ge(root.get("floor").as(Integer.class), 2));
        criteria.select( root );

        Query query = session4.createQuery(criteria);
//        query.setMaxResults(2);  // set limit
        List<Property> properties = query.getResultList();
        session4.close();
        System.out.println();
        System.out.println(properties);

        // example of object deletion
        Session session5 = sessionManager.getSessionFactoryInstance().openSession();
        session5.beginTransaction();
        session5.delete(properties.remove(1));
        session5.getTransaction().commit();

        session5.close();

    }

    public static List<Property> getAllProperties(){
        DbSessionManager sessionManager = new DbSessionManager();
        Session session = sessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Property> criteria = builder.createQuery(Property.class);
        Root<Property> root = criteria.from(Property.class);
        criteria.select( root );

        Query query = session.createQuery(criteria);
//        query.setMaxResults(2);  // set limit
        List<Property> properties = query.getResultList();
        return properties;
    }

}
