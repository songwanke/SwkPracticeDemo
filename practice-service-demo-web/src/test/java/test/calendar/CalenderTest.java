package test.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author songwanke
 * @date 2017/12/1
 */
public class CalenderTest {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.set(2017,11,1,14,52);
        long day1 = c.getTimeInMillis();
        System.out.println("day1****" +day1);
      /*  day1 += 1000*60*60;
        c.setTimeInMillis(day1);
        System.out.println("new hour:" +c.get(c.HOUR_OF_DAY));*/
        c.add(c.DATE,5);
        System.out.println("add 5 days:" + sdf.format(c.getTime()));
        c.roll(c.DATE,5);
        System.out.println("roll 30 days:" + sdf.format(c.getTime()));
        c.set(c.DATE,1);
        System.out.println("set to 1:" + sdf.format(c.getTime()));
        System.out.println("c.DATE is " + c.DATE);
    }
}
