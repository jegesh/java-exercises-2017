package il.co.electriccollege.restaurant.yossi.sql.dal;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dao.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class DishesDal {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_EGGS = "eggs";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_TYPE_OF_PASTA = "typeOfPasta";
    public static final String FIELD_SAUCE_TYPE = "sauce";
    public static final String FIELD_BREAD_TYPE = "breadType";
    public static final String FIELD_SIZE_OF_SANDWICH = "sizeOfSandwich";
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;
    private static final String TABLE_NAME = "dishes";


    public DishesDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    public boolean addDish(AbstractDish dish){
        String query1 = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) ";
        query1 = String.format(query1, TABLE_NAME, FIELD_NAME, FIELD_DESCRIPTION, FIELD_PRICE,
                FIELD_CATEGORY, FIELD_EGGS, FIELD_TYPE_OF_PASTA,
                FIELD_SAUCE_TYPE, FIELD_BREAD_TYPE, FIELD_SIZE_OF_SANDWICH);

        String query2 = "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";

        String name = dish.getName();
        String description = dish.getDescription();
        double price = dish.getPrice();
        Category category = dish.getCategory();
        String eggs = "NULL";
        String typeOfPasta = "NULL";
        String sauce = "NULL";
        String breadType = "NULL";
        String sizeOfSandwich = "NULL";

        if (dish instanceof Breakfast) {
            eggs =((Breakfast) dish).getEggs();
        }

        if (dish instanceof Pasta) {
            typeOfPasta = ((Pasta) dish).getTypeOfPasta();
            sauce = ((Pasta) dish).getSauce();
        }

        if (dish instanceof Sandwiches) {
            breadType = ((Sandwiches) dish).getBreadType();
            sizeOfSandwich = ((Sandwiches) dish).getSizeOfSandwich();
        }

        query2 = String.format(query2, name, description,  price,
                 category, eggs, typeOfPasta, sauce, breadType, sizeOfSandwich
        );

        int result = -1;
        try {
            result = executeUpdate(query1 + query2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result > 0;
    }

    public void getAllDishes()
    {

    }
    public void getTenCheapestDishes()
    {

    }
    public void getDishesByCategory(String category)
    {

    }

    public void removeDish(AbstractDish dish)
    {

    }
    public void updatePrice(AbstractDish dish, double i)
    {

    }

    private Statement getStatement() throws SQLException {
        conn = databaseConnector.getDbConnection();
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
