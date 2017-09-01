package il.co.electriccollege.restaurant.yossi.sql.dal;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dao.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.BREAKFAST;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.PASTA;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.SANDWICHES;


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

    public ArrayList<AbstractDish> getAllDishes(){
        ArrayList<AbstractDish> returnedObjs = null;
        String query = "SELECT * FROM dishes";
        ResultSet rs = executeQuery(query);

        if (rs != null) {
            returnedObjs = buildDishObject(rs);

            if (returnedObjs != null) {
                return returnedObjs;
            }

        }
        return null;

    }

    ////////////// ArrayList buildDishObject ///////
    private ArrayList<AbstractDish> buildDishObject(ResultSet rs) {
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
                    float price = rs.getFloat(FIELD_PRICE);
                    String category = rs.getString(FIELD_CATEGORY);

                    AbstractDish dish = null;
                    if (category.equals(BREAKFAST.name())) {
                        dish = new Breakfast(
                                name,
                                description,
                                price,
                                BREAKFAST,
                                rs.getString(FIELD_EGGS)

                        );
                    }
                    if (category.equals(PASTA.name())) {
                        dish = new Pasta(
                                name,
                                description,
                                price,
                                PASTA,
                                rs.getString(FIELD_TYPE_OF_PASTA),
                                rs.getString(FIELD_SAUCE_TYPE)
                        );

                    }
                    if (category.equals(SANDWICHES.name())) {
                        dish = new Sandwiches(
                                name,
                                description,
                                price,
                                SANDWICHES,
                                rs.getString(FIELD_BREAD_TYPE),
                                rs.getString(FIELD_SIZE_OF_SANDWICH)
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


    public ArrayList<AbstractDish> getTenCheapestDishes()
    {
        ArrayList<AbstractDish> returnedObjs = null;
        String query = "SELECT * FROM dishes ORDER BY price ASC LIMIT 3";
        ResultSet rs = executeQuery(query);

        if (rs != null) {
            returnedObjs = buildDishObject(rs);

            if (returnedObjs != null) {
                return returnedObjs;
            }

        }
        return null;
    }
    public ArrayList<AbstractDish> getDishesByCategory(String category)
    {
        ArrayList<AbstractDish> returnedObjs = null;
        String query = "SELECT * FROM dishes WHERE category ='" + category + "'";
        ResultSet rs = executeQuery(query);

        if (rs != null) {
            returnedObjs = buildDishObject(rs);

            if (returnedObjs != null) {
                return returnedObjs;
            }

        }
        return null;
    }

    public boolean removeDish(AbstractDish dish)
    {
        String name = dish.getName();
        String description = dish.getDescription();
        String query = "DELETE FROM dishes WHERE name='" + name + "' and description='" + description + "'";
        int result = -1;
        try {
            System.out.println(query);
            result = executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result > 0;
    }
    public boolean updatePrice(AbstractDish dish, double price)
    {
        String name = dish.getName();
        String description = dish.getDescription();

        String query = "UPDATE dishes SET price=" + price + " WHERE name='" + name + "' and description='" + description + "'";
        System.out.println(query);
        int result = -1;

        try {
            result = executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return result > 0;
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
