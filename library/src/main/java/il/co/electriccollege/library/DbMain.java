package il.co.electriccollege.library;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dal.MediaDal;
import il.co.electriccollege.library.sql.dao.AbstractMedia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yaakov on 8/23/17.
 */
public class DbMain {

    public static void main(String[] args) {
        MediaDal mediaDal = new MediaDal(new DatabaseConnector());
        AbstractMedia returnedMedia = mediaDal.getById(1);
        System.out.println(returnedMedia);
    }
}
