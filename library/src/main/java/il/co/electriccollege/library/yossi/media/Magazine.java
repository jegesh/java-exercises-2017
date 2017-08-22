package il.co.electriccollege.library.yossi.media;

import java.util.Date;

public class Magazine extends AbstractMedia{

    private String issueNo;

    public Magazine(int id, String name, String publisher, Date publicationDate, String issueNo) {
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
