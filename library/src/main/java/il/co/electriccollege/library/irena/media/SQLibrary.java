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
    public boolean addMedia(AbstractMedia abstractMedia){
        String sql = "INSERT into MEDIA ("+ abstractMedia.getName()+", "+ abstractMedia.getPublisher()+", "+ abstractMedia.getPublicationDate()+", "+MediaStatus.AVAILABLE+", "+null;
        if(abstractMedia instanceof AudioBook){
            sql += ", "+((AudioBook) abstractMedia).getNarrator()+", "+((AudioBook) abstractMedia).getDuration();
        }
        if(abstractMedia instanceof Magazine){
            sql += ", "+((Magazine) abstractMedia).getIssueNum();
        }
        sql += ")";
        db.getQuery(sql);
        return true;
    }

    public boolean getMedia(){
        return true;
    }
}
