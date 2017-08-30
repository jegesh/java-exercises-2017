package il.co.electriccollege.restaurant.yossi.sql.dal;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dao.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;


public class DishesDal {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_EGGS = "eggs";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_TYPE_OF_PASTA = "type of pasta";
    public static final String FIELD_SAUCE_TYPE = "sauce type";
    public static final String FIELD_BREAD_TYPE = "bread type";
    public static final String FIELD_SIZE_OF_SANDWICH = "size of sandwich";
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;
    private static final String TABLE_NAME = "restaurant";


    public DishesDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    public void addDish(AbstractDish dish){
        String query1 = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s' %s) ";
        query1 = String.format(query1, TABLE_NAME, FIELD_NAME, FIELD_DESCRIPTION, FIELD_PRICE,
                FIELD_CATEGORY, FIELD_EGGS, FIELD_TYPE_OF_PASTA,
                FIELD_SAUCE_TYPE, FIELD_BREAD_TYPE, FIELD_SIZE_OF_SANDWICH);

        String query2 = "VALUES ('%s', '%s', '%s', '%s', '%s', %s, '%s', '%s', '%s', '%s')";

        String name = dish.getName();
        String description = dish.getDescription();
        int price = 0;
        Category category = null;
        String typeOfPasta = null;
        String sauce = null;
        String eggs = null;
        String breadType = null;
        String sizeOfSandwich = null;

        if (dish instanceof Breakfast) {
            eggs = "'" + ((Breakfast) dish).getEggs() + "'";
        }

        if (dish instanceof Pasta) {
            typeOfPasta = "'" + ((Pasta) dish).getTypeOfPasta() + "'";
            sauce = "'" + ((Pasta) dish).getSauce() + "'";
        }

        if (dish instanceof Sandwiches) {
            breadType = "'" + ((Sandwiches) dish).getBreadType() + "'";
            sizeOfSandwich = "'" + ((Sandwiches) dish).getSizeOfSandwich() + "'";
        }

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
    public void updatePrice(AbstractDish dish, float i)
    {

    }
}
