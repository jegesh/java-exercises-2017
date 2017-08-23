package il.co.electriccollege.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yaakov on 8/22/17.
 */
public class ExceptionPractice {
    Date currentDate;

    public ExceptionPractice(){
//        currentDate = getDateWithSimpleFormat("09/9/1999");
    }


    public Date getDateWithSimpleFormat(String dateStr) throws IllegalArgumentException, ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(dateStr.length() != 10)
            throw new IllegalArgumentException("Date string must be exactly 10 characters");
//        return new Date();
        return dateFormat.parse("21/08/2017");
    }
}
