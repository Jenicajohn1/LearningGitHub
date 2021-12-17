package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returNextMonth() {
        //Creating Date object
        Date dNow = new Date();

        // Creating calendar object
        Calendar calendar = new GregorianCalendar();

        //Set Calendar date to current date
        calendar.setTime(dNow);

        //Create object of simpledateformat
        //Defining date format to-example:(Dec-2021)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(Calendar.MONTH,1);

        //Incrementing the current month
        calendar.add(Calendar.MONTH,1);

        //Generating the date based on the specified format
        String date = sdf.format(calendar.getTime());

        return  date;
    }
}
