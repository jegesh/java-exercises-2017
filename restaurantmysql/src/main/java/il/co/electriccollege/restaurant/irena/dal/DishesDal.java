package il.co.electriccollege.restaurant.irena.dal;


import il.co.electriccollege.restaurant.irena.model.DatabaseConnector;
import il.co.electriccollege.restaurant.irena.dao.*;
import il.co.electriccollege.restaurant.irena.enums.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by IrKha on 29.08.2017.
 */
public class DishesDal {
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PRICE = "price";
    private static final String FIELD_CATEGORY_NAME = "category_name";
    private static final String FIELD_ID = "id";
    private static final String FIELD_GARNISH = "garnish";
    private static final String TABLE_NAME = "dishes";
    private static final String FIELD_CATEGORY_ID = "category_id";
    private static final String TABLE_CATEGORY_NAME = "category";
    private static final String FIELD_DRINK = "drink";
    private static final String FIELD_ROASTING = "roasting";
    private static final String FIELD_DESCRIPTION = "description";
    private static final int NUMBER_OF_DISHES = 10;

    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;
    private ArrayList<Dish> dishes;

    public DishesDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    /**
     * gets all dishes from DB
     * @return
     */
    public ArrayList<Dish> getAllDishes(){
        String query = "SELECT * FROM %s LEFT JOIN %s ON %s = %s";
        ResultSet rs = executeQuery(String.format(query, TABLE_NAME, TABLE_CATEGORY_NAME, TABLE_NAME+"."+FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME+"."+FIELD_CATEGORY_ID));
        if(rs != null){
           return buildDishObject(rs);
        }
        return null;
    }

    /**
     * gets top of dishes depends of number of and sort direction
     * @param sortingEnum
     * @return
     */
    public ArrayList<Dish> getTops(SortingEnum sortingEnum, int num){
        String query = "SELECT * FROM %s LEFT JOIN %s ON %s = %s ORDER BY %s %s LIMIT %s";
        ResultSet rs = executeQuery(String.format(query, TABLE_NAME, TABLE_CATEGORY_NAME, TABLE_NAME+"."+FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME+"."+FIELD_CATEGORY_ID, FIELD_PRICE, sortingEnum, num));
            return buildDishObject(rs);
    }

    /**
     * gets dishes form DB depends on category
     * @param category
     * @return
     */
    public ArrayList<Dish> getDishByCategory(CategoryEnum category){
       String query = "SELECT * FROM %s LEFT JOIN %s ON %s = %s WHERE %s = '%s'";
       ResultSet rs = executeQuery(String.format(query,TABLE_NAME, TABLE_CATEGORY_NAME, TABLE_NAME+"."+FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME+"."+FIELD_CATEGORY_ID, FIELD_CATEGORY_NAME, category));
       return buildDishObject(rs);
    }

    /**
     * gets dish by id
     * @param id
     * @return
     * @throws SQLException
     */
    public Dish getById(int id){
        String query = "SELECT * FROM %s LEFT JOIN %s ON %s = %s WHERE %s = '%s'";
        ResultSet rs = executeQuery(String.format(query, TABLE_NAME, TABLE_CATEGORY_NAME,TABLE_NAME+"."+FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME+"."+FIELD_CATEGORY_ID, FIELD_ID, id));
        if(rs != null){
          ArrayList<Dish> dishes  = buildDishObject(rs);
          if(dishes != null) return dishes.get(0);
        }
        return null;
    }

    /**
     * gets dishes by name
     * @param name
     * @return
     */
    public ArrayList<Dish> getByName(String name) {
        String query = "SELECT * FROM %s LEFT JOIN %s ON %s = %s WHERE %s LIKE '%%s%'";
        ResultSet rs = executeQuery(String.format(query, TABLE_NAME, TABLE_CATEGORY_NAME,TABLE_NAME+"."+FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME+"."+FIELD_CATEGORY_NAME,FIELD_NAME));
        return buildDishObject(rs);
    }

    /**
     * add Dish to DB
     * @param dish
     * @return
     */
    public boolean addDish(Dish dish){
        String name = dish.getName();
        String description = dish.getDescription()!=null?dish.getDescription():"";
        float price = dish.getPrice();
        String garnish = "";
        String drink = "";
        String roasting = "";
        String category_name = dish.getClass().getSimpleName();
        int category_id = getCategoryId(category_name);
        if(dish instanceof BusinessLunch){
            garnish = ((BusinessLunch) dish).getGarnish().name();
        }
        if(dish instanceof Dessert){
            drink = ((Dessert) dish).getDrinkEnum().name();
        }
        if(dish instanceof Grill){
            roasting = ((Grill) dish).getRoasting().name();
        }
        String query = "INSERT into %s (%s,%s,%s,%s,%s,%s,%s) ";
        String queryRes = "VALUES ('%s', '%s', %s, %s,'%s','%s','%s')";
        query = String.format(query, TABLE_NAME, FIELD_NAME, FIELD_DESCRIPTION, FIELD_PRICE, FIELD_CATEGORY_ID, FIELD_GARNISH,FIELD_DRINK, FIELD_ROASTING);
        queryRes = String.format(queryRes, name,description,price,category_id,garnish,drink,roasting);

        return executeUpdate(query+queryRes)>0;
    }
    /**
     * updating price for dish
     * @param dish
     * @param price
     * @return
     */
    public boolean updatePrice(Dish dish, float price){
        String query = "UPDATE %s SET %s = %s WHERE %s = %s";
        return executeUpdate(String.format(query, TABLE_NAME, FIELD_PRICE, price, FIELD_ID, dish.getId()))>0;
    }

    public boolean removeDish(Dish dish){
        String query = "DELETE from %s WHERE %s = %s";
        return executeUpdate(String.format(query,TABLE_NAME,FIELD_ID,dish.getId()))>0;
    }

    private int getCategoryId(String categoryName) {
        String query = "SELECT %s FROM %s WHERE %s = '%s'";
        ResultSet rs = executeQuery(String.format(query,FIELD_CATEGORY_ID, TABLE_CATEGORY_NAME, FIELD_CATEGORY_NAME, categoryName));
        if(rs != null){
            try {
                rs.next();
                return rs.getInt(FIELD_CATEGORY_ID);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
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
        System.out.println(queryStr);
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
        System.out.println(queryStr);
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

    private ArrayList<Dish> buildDishObject(ResultSet rs){
        dishes = new ArrayList<>();
        boolean hasNextRow = true;
        while(hasNextRow){
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if(hasNextRow){
                    String name  = rs.getString(FIELD_NAME);
                    float price = rs.getFloat(FIELD_PRICE);
                    String category = rs.getString(FIELD_CATEGORY_NAME);
                    Dish dish = null;
                   /* System.out.println(rs.getString(FIELD_CATEGORY_NAME));
                    System.out.println(BusinessLunch.class.getSimpleName());*/
                    if (rs.getString(FIELD_CATEGORY_NAME).equals(BusinessLunch.class.getSimpleName())){
                        Garnish garnish = Garnish.valueOf(rs.getString(FIELD_GARNISH));
                        dish = new BusinessLunch(garnish);
                    }
                    if (rs.getString(FIELD_CATEGORY_NAME).equals(Dessert.class.getSimpleName())){
                        DrinkEnum drinkEnum = DrinkEnum.valueOf(rs.getString(FIELD_DRINK));
                        dish = new Dessert(drinkEnum);
                    }
                    if (rs.getString(FIELD_CATEGORY_NAME).equals(Grill.class.getSimpleName())){
                        Roasting roasting = Roasting.valueOf(rs.getString(FIELD_ROASTING));
                        dish = new Grill(roasting);
                    }
                    dish.setName(name);
                    dish.setPrice(price);
                    dish.setId(rs.getInt(FIELD_ID));
                    dishes.add(dish);
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
        return dishes;
    }

}
