package il.co.electriccollege.restaurant.gil.sql.dal;

import il.co.electriccollege.restaurant.gil.sql.DatabaseConnector;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Comp3 on 30/08/17.
 */
public class DishDal {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_DESCRIPTION = "description";
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;
    private static final String FIELD_DISH_TYPE = "dish_type";
    private static final String TABLE_NAME = "dishes";



}
