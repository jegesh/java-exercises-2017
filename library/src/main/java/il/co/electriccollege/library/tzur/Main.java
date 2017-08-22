package il.co.electriccollege.library.tzur;


import il.co.electriccollege.library.tzur.media.Book;
import il.co.electriccollege.library.tzur.media.MediaStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
//        Calendar calendar = new GregorianCalendar();
//        calendar.set(Calendar.YEAR, 2017);
//        calendar.set(Calendar.MONTH, Calendar.AUGUST);
//        calendar.set(Calendar.DATE, 21);
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date d = dateFormat.parse("21/08/2017");

        Book book1 = new Book("book1", "publisher1",getDateWithSimpleFormat("21/08/2017"));

    }

    /**
     *
     * @param dateStr date in the format of dd/MM/yyyy
     * @return
     */
    public static Date getDateWithCalendar(String dateStr){
        String[] strs = dateStr.split("/");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.valueOf(strs[2]));
        calendar.set(Calendar.MONTH, Integer.valueOf(strs[1]) - 1);
        calendar.set(Calendar.DATE, Integer.valueOf(strs[0]));
        return calendar.getTime();
    }

    public static Date getDateWithSimpleFormat(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse("21/08/2017");
    }
}
