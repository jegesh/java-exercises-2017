package il.co.electriccollege.restaurant.dal;

import il.co.electriccollege.restaurant.dao.DBConnector;
import il.co.electriccollege.restaurant.dish.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Comp14 on 30/08/2017.
 */
public class DishDAL {
    private DBConnector databaseConnector;
    private Statement stmt;
    private Connection conn;

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_CATEGORY = "category";
    public static final String TABLE_NAME = "dishes";



    private ArrayList<AbstractDish> returnedList;

    public DishDAL(DBConnector dbConnector) {
    }

    public boolean addDishToRestaurant(AbstractDish dish) {
        // fields: name, publication_date, media_type, media_status, publisher, narrator, duration, issue
        String query1 = "INSERT INTO %s (%s, %s, %s, %s) ";
        query1 = String.format(query1, TABLE_NAME, FIELD_NAME, FIELD_DESCRIPTION,
                FIELD_PRICE,  FIELD_CATEGORY);

        String query2 = "VALUES ('%s', '%s', %s, '%s')";
        String name = dish.getName();
        String description = dish.getDescription();
        DishCategory category = null;
        double price = dish.getPrice();

        if (dish instanceof StartDish) {

            category = ((StartDish) dish).getDishCategory();
        }
        if (dish instanceof MainDish) {

            category = ((MainDish) dish).getDishCategory();
        }

        if (dish instanceof EndDish) {

            category = ((EndDish) dish).getDishCategory();
        }
        query2 = String.format(query2, name, description,price, category );
        int result = -1;
        try {
            System.out.println(query1 + query2);
            result = executeUpdate(query1 + query2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result > 0;

    }


    private ArrayList<AbstractDish> buildMediaObject(ResultSet rs){
        ArrayList<AbstractDish> dishList = new ArrayList<AbstractDish>();

        boolean hasNextRow = true;
        while (hasNextRow) {
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if (hasNextRow) {
                    String name = rs.getString(FIELD_NAME);
                    String description = rs.getString(FIELD_DESCRIPTION);
                    float price= rs.getFloat(FIELD_PRICE);
                    String category = rs.getString(FIELD_CATEGORY);

                    AbstractDish dish = null;

                    if (category.equals(DishCategory.START_DISH.name())) {
                        dish = new StartDish(
                                name,
                                description,
                                price


                        );
                    }
                    if (category.equals(DishCategory.MAIN_DISH.name())) {
                        dish= new MainDish(
                                name,
                                description,
                                price

                        );

                    }
                    if (category.equals(DishCategory.END_DISH.name())) {
                        dish = new EndDish(
                                name,
                                description,
                                price

                        );
                    }
                  
                   dish.setId(rs.getInt(FIELD_ID));
                    dishList.add(dish);
                }

            } catch (SQLException e) {
                e.printStackTrace();

                return null;
            }


        }
        //finally block used to close resources
        try {
            rs.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
            // nothing we can do
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return dishList;
    }

    private Statement getStatement() throws SQLException {
        conn = databaseConnector.getDBConnection();
        if (conn != null) {

            System.out.println("Creating database statement");
            // create query statement
            stmt = conn.createStatement();
            return stmt;
        }
        throw new SQLException("Unable to connect to database");
    }

    private int executeUpdate(String queryStr) {
        try {
            stmt = getStatement();
            int result = stmt.executeUpdate(queryStr);
            return result;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return -1;
    }

    private ResultSet executeQuery(String queryStr) {
        try {
            stmt = getStatement();
            ResultSet rs = stmt.executeQuery(queryStr);
            return rs;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return null;
    }
}
