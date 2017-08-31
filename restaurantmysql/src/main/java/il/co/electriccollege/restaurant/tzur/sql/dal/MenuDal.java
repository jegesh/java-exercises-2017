package il.co.electriccollege.restaurant.tzur.sql.dal;


import il.co.electriccollege.restaurant.tzur.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.tzur.sql.dao.*;
import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class MenuDal {
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;

    public static final String TABLE_NAME = "dishes";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_INCLUDE_DRINK = "include_drink";
    public static final String FIELD_SATIATION_LEVEL = "satiation_level";
    public static final String FIELD_SWEET_LEVEL = "sweet_level";


    //basic SQL methods
    public MenuDal(DatabaseConnector connector) {
        databaseConnector = connector;
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

    public boolean addDishToMenu(Dish dish) {


        String query1 = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) ";
        query1 = String.format(query1, TABLE_NAME, FIELD_NAME, FIELD_DESCRIPTION,
                FIELD_PRICE, FIELD_CATEGORY, FIELD_INCLUDE_DRINK, FIELD_SATIATION_LEVEL,
                FIELD_SWEET_LEVEL);

        String query2 = "VALUES ('%s','%s', '%s', '%s', %s, %s, %s)";
        String name = dish.getName();
        String description = dish.getDescription();
        String price = "" + dish.getPrice();
        String category = dish.getCategory().name();
        String includeDrink = null;
        String satiationLevel = null;
        String sweetLevel = null;

        if (dish instanceof FirstDish) {
            includeDrink = "" + fromBoolToInt(((FirstDish) dish).isIncludeDrink());

        }
        if (dish instanceof MainDish) {
            satiationLevel = "" + ((MainDish) dish).getSatiationLevel();
        }
        if (dish instanceof DessertDish) {
            sweetLevel = "" + ((DessertDish) dish).getSweetLevel();
        }

        query2 = String.format(query2, name, description, price, category,
                includeDrink, satiationLevel, sweetLevel);
        int result = -1;
        try {
            result = executeUpdate(query1 + query2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result > 0;
    }

    private int fromBoolToInt(boolean boolNum) {
        return boolNum ? 1 : 0;
    }

    private boolean fromIntToBool(int intNum) {
        return intNum == 0 ? false : true;
    }

    private ArrayList<Dish> buildMediaObject(ResultSet rs) {
        ArrayList<Dish> dishList = new ArrayList<>();
        boolean hasNextRow = true;
        while (hasNextRow) {
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if (hasNextRow) {
                    int dishId = rs.getInt(FIELD_ID);
                    String name = rs.getString(FIELD_NAME);
                    String description = rs.getString(FIELD_DESCRIPTION);
                    float price = rs.getFloat(FIELD_PRICE);
                    Category category = Category.valueOf(rs.getString(FIELD_CATEGORY));
                    boolean includeDrink = rs.getBoolean(FIELD_INCLUDE_DRINK);
                    int satiationLevel=rs.getInt(FIELD_SATIATION_LEVEL);
                    int sweetLevel=rs.getInt(FIELD_SWEET_LEVEL);

                    Dish dish = null;

                    if (category.name().equals(Category.FIRST.name())) {

                        dish = new FirstDish(dishId, name, description, price, includeDrink);
                    }
                    if (category.name().equals(Category.MAIN.name())) {

                        dish = new MainDish(dishId, name, description, price, satiationLevel);
                    }
                    if (category.name().equals(Category.DESSERT.name())) {
                        dish = new DessertDish(dishId, name, description, price, sweetLevel);
                    }
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

    public Dish getById(int id) {
        String query = "SELECT * FROM %s WHERE id = %s";
        ResultSet rs = executeQuery(String.format(query,TABLE_NAME, id));
        if (rs != null) {
            ArrayList<Dish> returnedObjs = buildMediaObject(rs);
            if (returnedObjs != null) {
                return returnedObjs.get(0);
            }
        }
        return null;
    }

    public boolean removeDish(Dish dish) {
        //DELETE FROM table_name WHERE some_column = some_value
        String query = "DELETE FROM %s WHERE %s=%s";
        executeUpdate(String.format(query, TABLE_NAME, FIELD_ID, dish.getDishId()));
        return false;

    }
}




