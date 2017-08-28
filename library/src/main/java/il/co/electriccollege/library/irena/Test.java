package il.co.electriccollege.library.irena;

import il.co.electriccollege.library.irena.sql.DatabaseConnector;
import il.co.electriccollege.library.irena.sql.dal.MediaDal;
import il.co.electriccollege.library.irena.sql.dal.MediaType;
import il.co.electriccollege.library.irena.sql.dao.AbstractMedia;
import il.co.electriccollege.library.irena.sql.dao.AudioBook;
import il.co.electriccollege.library.irena.sql.dao.Magazine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Comp8 on 23/08/17.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        MediaDal md = new MediaDal(new DatabaseConnector());

        AbstractMedia media = md.getById(1);

        ArrayList<AbstractMedia> mb = md.getByMediaType(MediaType.BOOK);

        for(AbstractMedia m: mb){
            System.out.println(m);
        }
        md.checkoutMedia(1);
        md.returnMedia(1);
        mb = md.getByName("ord");
        for(AbstractMedia m: mb){
            System.out.println(m);
        }

        Magazine magazine = new Magazine("Cool","coolpub", LocalDate.of(1970,12,12), "new");
        AudioBook audioBook = new AudioBook("Gosti","Tolstoi", LocalDate.of(2017,02,02), "Tis", 120);
        System.out.println(md.addMediaToLib(audioBook));
    }
}
