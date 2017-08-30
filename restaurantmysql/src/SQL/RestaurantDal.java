package SQL;
import dishes.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RestaurantDal {

    private  DatabaseConnector datebaseConnector;
    private  Connection conn;
    private Statement stmt;

    public RestaurantDal(DatabaseConnector databaseConnector)
    {
        this.datebaseConnector=databaseConnector;
    }

    private Statement getStatement() throws SQLException
    {
        conn= datebaseConnector.getDbConnection();
        if(conn!=null)
        {
            System.out.println("Creating database statement");
            // create query statement
            stmt = conn.createStatement();
            return stmt;
        }
        throw new SQLException("Unable to connect to database");
    }

    private int executeUpdate(String queryStr)
    {
        try {
            stmt = getStatement();
            int result = stmt.executeUpdate(queryStr);
            return result;
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
        return -1;
    }

    private ResultSet executeQuery(String queryStr)
    {
        try {
            stmt = getStatement();
            ResultSet result = stmt.executeQuery(queryStr);
            return result;
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
        return null;

    }
    public ArrayList<AbstractDish> getDishObject(ResultSet rs)
    {
        ArrayList<AbstractDish> arrayDish= new ArrayList<AbstractDish>();
        boolean hasNextRow=true;
        while(hasNextRow)
        {
            try {

                hasNextRow=rs.next();
                if (hasNextRow) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    float price = rs.getInt("price");
                    String categoryString = rs.getString("catagory");

                    AbstractDish dish=null;

                    if (categoryString.equals("BusinessLunch")) {
                        DishCatagory catagory = DishCatagory.BusinessLunch;
                        dish = new BusinessLunch(id, name, price, catagory);
                    } else if (categoryString.equals("SideDish")) {
                        DishCatagory catagory = DishCatagory.SideDish;
                        dish = new SideDish(id, name, price, catagory);
                    } else if (categoryString.equals("StandardDish")) {
                        DishCatagory catagory = DishCatagory.StandardDish;
                        dish = new StandardDish(id, name, price, catagory);
                    }


                    arrayDish.add(dish);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrayDish;
    }


    public ArrayList<AbstractDish> getAllDishes()
    {
        ArrayList<AbstractDish> arrayOfAllDishes= new ArrayList<AbstractDish>();
        String query= "SELECT * FROM dishes";
        ResultSet rs= executeQuery(query);

        arrayOfAllDishes=getDishObject(rs);

        return arrayOfAllDishes;
    }

    public ArrayList<AbstractDish> getTenCheapestDishes()
    {
        ArrayList<AbstractDish> arrayOfTenCheapestDishes= new ArrayList<AbstractDish>();
        String query= "SELECT * FROM dishes ORDER BY price LIMIT 10";
        ResultSet rs= executeQuery(query);
        if(rs !=null) {
            arrayOfTenCheapestDishes = getDishObject(rs);
            return arrayOfTenCheapestDishes;
        }
        return null;
    }

    public ArrayList<AbstractDish> getDishesByCategory(DishCatagory catagory)
    {
        ArrayList<AbstractDish> arrayOfDishesByCategory= new ArrayList<AbstractDish>();
        String query= "SELECT * FROM dishes WHERE catagory like '%s'";

        ResultSet rs= executeQuery(String.format(query,catagory));
        if(rs !=null) {
            arrayOfDishesByCategory = getDishObject(rs);
            return arrayOfDishesByCategory;
        }
        return  null;
    }

    public boolean addDish(AbstractDish dish)
    {
        boolean answer=false;
        int price= (int)dish.getPrice();
        String query="INSERT INTO dishes (id, name , description, price, catagory) VALUES ( '%s' , '%s' , '%s' , '%s' , '%s')";
        query= String.format(query, dish.getId(),dish.getName(), dish.getDescription(),price, dish.getCatagory() );
       // String query= "INSERT INTO dishes VALUES( %s , %s , %s , %s, %s ) ";



        int result= executeUpdate(query);
        if (result!=-1)
        {
            System.out.println("you add successfully dish to the DB");
            //    answer=true;
            return true; //if the return is activated, so the method exits?
        }
        System.out.println("you NOT added successfully dish to the DB");


        return answer;
    }

    public boolean removeDish(AbstractDish dish)
    {
        String query= "DELETE from dishes WHERE id = %s";
        query= String.format(query, dish.getId());
        int result= executeUpdate(query);

        if (result!=-1)
        {
            System.out.println("you removed successfully dish from the DB");
            //    answer=true;
            return true; //if the return is activated, so the method exits?
        }
        System.out.println("you NOT added successfully dish to the DB");

        return false;
    }

    public boolean updatePrice(AbstractDish dish, float price)
    {
        String query= "UPDATE dishes SET price = %s WHERE id=%s";
        query=String.format(query,price,dish.getId());
        int result= executeUpdate(query);
        if (result!=-1)
        {
            System.out.println("you updated successfully dish to the DB");
            //    answer=true;
            return true; //if the return is activated, so the method exits?
        }
        System.out.println("you NOT updated successfully dish to the DB");

        return false;
    }


}


