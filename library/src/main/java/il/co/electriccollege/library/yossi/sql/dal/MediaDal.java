package il.co.electriccollege.library.yossi.sql.dal;

import java.sql.Connection;

public class MediaDal {
    private Connection dbConnection;

    public MediaDal(Connection connection){
        dbConnection = connection;
    }
}
