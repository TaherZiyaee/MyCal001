import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate01 {

    private PersianCalendar pc1,pc2;
    private GregorianCalendar gc1,gc2;

    private void definePersianRange() {
        pc1 = new PersianCalendar(1400,PersianCalendarConstants.ORDIBEHESHT,01);
        pc2 = new PersianCalendar(1400,PersianCalendarConstants.ORDIBEHESHT,31);
    }

    public void convertSHtoMIL() {
        definePersianRange();
        gc1 = new GregorianCalendar();
        gc2 = new GregorianCalendar();
        gc1.setTime(pc1.getTime());
        gc2.setTime(pc2.getTime());

        System.out.printf("Julian Date: %s\n",new MyDate01().setFormat(gc1));
        System.out.printf("Julian Date: %s\n",new MyDate01().setFormat(gc2));
    }

    private String setFormat(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    public int findFriday() {
        Calendar start = GregorianCalendar.getInstance();
        start.setTime(pc1.getTime());
        Calendar end = GregorianCalendar.getInstance();
        end.setTime(pc2.getTime());

        int numberOfFriday = 0;
        int friday = Calendar.FRIDAY;

        while (!start.after(end)) {
            if (start.get(Calendar.DAY_OF_WEEK) == friday) {
                numberOfFriday++;
                System.out.printf("Friday #%d: %s\n",numberOfFriday,start.get(Calendar.DATE));
                start.add(Calendar.DATE,7);
            } else
                start.add(Calendar.DATE,1);
        }
        return numberOfFriday;
    }

    public int findFridayThursdayW
}
