package il.co.electriccollege.library.yossi.sql.dao;

import java.util.Date;

public class Magazine extends AbstractMedia {
    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    private String issueNo;

    //constractors
    public Magazine(String name, String publisher, Date publicationDate, String issueNo) {
        super(name, publisher, publicationDate);
        this.issueNo = issueNo;
    }


    //implement methods
    public int getFine() {
        // TODO: 21/08/2017
        return 0;
    }

    public int getMaxLoan() {
        // TODO: 21/08/2017
        return 14;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNo='" + issueNo + '\'' +
                "} " + super.toString();
    }
}
