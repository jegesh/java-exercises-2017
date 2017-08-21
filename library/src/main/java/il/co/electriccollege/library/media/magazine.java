package il.co.electriccollege.library.media;

import java.util.Date;

import static il.co.electriccollege.library.media.MediaStatus.AVAILABLE;

public class magazine extends AbstractMedia{

    private String issueNo;

    public magazine(int id, String name, MediaStatus status, String publisher, Date publicationDate, String issueNo) {
        super(id, name, AVAILABLE, publisher, publicationDate);
        this.issueNo = issueNo;
        //MediaStatus = AVAILABLE;
    }


}
