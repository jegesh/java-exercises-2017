package il.co.electriccollege.library.irena;

import il.co.electriccollege.library.irena.sql.DatabaseConnector;
import il.co.electriccollege.library.irena.sql.dal.MediaDal;
import il.co.electriccollege.library.irena.sql.dao.AbstractMedia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Comp8 on 23/08/17.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        MediaDal md = new MediaDal(new DatabaseConnector());
        AbstractMedia media = md.getById(1);
        System.out.println(media);
    }
}
