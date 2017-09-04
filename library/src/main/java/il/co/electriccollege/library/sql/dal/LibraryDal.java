package il.co.electriccollege.library.sql.dal;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dao.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yaakov on 9/4/17.
 */
public class LibraryDal {
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;

    public LibraryDal(){
        databaseConnector = new DatabaseConnector();
    }

    public Library getById(int id) {
        String query = "SELECT * FROM library WHERE id = %s";
        ResultSet rs = executeQuery(String.format(query, id));
        if (rs != null) {
            ArrayList<Library> returnedObjs = buildLibraryObject(rs);
            if (returnedObjs != null)
                return returnedObjs.get(0);
        }
        return null;
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

    private ArrayList<Library> buildLibraryObject(ResultSet rs) {
        ArrayList<Library> libraryList = new ArrayList<>();
        boolean hasNextRow = true;
        while (hasNextRow) {
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if (hasNextRow) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    int id = rs.getInt("id");

                    Library lib = new Library();
                    lib.setAddress(address);
                    lib.setId(id);
                    lib.setName(name);

                    libraryList.add(lib);
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
        return libraryList;
    }
}
