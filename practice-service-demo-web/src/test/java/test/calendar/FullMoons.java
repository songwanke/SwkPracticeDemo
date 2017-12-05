package test.calendar;

import java.util.Calendar;

/**
 * @author songwanke
 * @date 2017/12/1
 */
public class FullMoons {

    static int DAY_IM = 1000*60*60;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004,0,7,16,40);
        long day1 = c.getTimeInMillis();
        /*for(int x=0;x<6;x++){
            day1 += (DAY_IM * 29.52);
        }*/
        day1 += (DAY_IM * 29.52*6);
        c.setTimeInMillis(day1);
        System.out.println(String.format("full moon on %tc",c));
    }
}
