package il.co.electriccollege.library.irena.media;

import il.co.electriccollege.library.irena.sql.DBClass;

/**
 * Created by IrKha on 21.08.2017.
 */
public class SQLibrary {
    private DBClass db;
    public SQLibrary(){
        db = new DBClass();
    }
    public boolean addMedia(Media media){
        String sql = "INSERT into MEDIA ("+media.getName()+", "+media.getPublisher()+", "+media.getPublicationDate()+", "+MediaStatus.AVAILABLE+", "+null;
        if(media instanceof AudioBook){
            sql += ", "+((AudioBook) media).getNarrator()+", "+((AudioBook) media).getDuration();
        }
        if(media instanceof Magazine){
            sql += ", "+((Magazine) media).getIssueNum();
        }
        sql += ")";
        db.getQuery(sql);
        return true;
    }

    public boolean getMedia(){
        return true;
    }
}
