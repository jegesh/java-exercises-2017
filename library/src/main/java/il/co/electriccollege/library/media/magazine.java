package il.co.electriccollege.library.media;

import java.util.Date;

import static il.co.electriccollege.library.media.MediaStatus.AVAILABLE;

public class magazine extends AbstractMedia{

    private String issueNo;

    public magazine(int id, String name, String publisher, Date publicationDate, String issueNo) {
        super(id, name, publisher, publicationDate);
        this.issueNo = issueNo;
        //MediaStatus = AVAILABLE;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    @Override
    public String toString() {
        return super.toString() + "magazine{" +
                "issueNo='" + issueNo + '\'' +
                '}';
    }
}