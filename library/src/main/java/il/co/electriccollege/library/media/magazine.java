package il.co.electriccollege.library.media;

import java.util.Date;

import static il.co.electriccollege.library.media.MediaStatus.AVAILABLE;

public class magazine extends AbstractMedia{

    private String issueNo;

    public magazine(String name, int id, MediaStatus status, String publisher, Date publicationDate, String issueNo) {
        super(name, id, AVAILABLE, publisher, publicationDate);
        this.issueNo = issueNo;
        //MediaStatus = AVAILABLE;
    }
}
