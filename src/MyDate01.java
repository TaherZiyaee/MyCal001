import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyDate01 {

    private com.ibm.icu.util.Calendar pc1 = new PersianCalendar(new Date());
    private com.ibm.icu.util.Calendar pc2 = new PersianCalendar(new Date());

    private void setPersianDate() {
        pc1.set(1400, PersianCalendarConstants.KHORDAD,21);
        pc2.set(1400,PersianCalendarConstants.TIR,20);
    }

    public int findFriday() {   // must be private
        setPersianDate();

        Locale loc = new Locale("FA","IR");
        DateFormat df = pc1.getDateTimeFormat(DateFormat.DEFAULT,DateFormat.SHORT,loc);
        DateFormat df1 = DateFormat.getDateInstance(pc1,DateFormat.DEFAULT,loc);

        int numberOfFri = 0;
        while (!pc1.after(pc2)) {
            if (pc1.get(PersianCalendar.DAY_OF_WEEK) == PersianCalendar.FRIDAY) {
                numberOfFri++;
//                System.out.printf("Friday #%d: %s\n",numberOfFri,df.format(pc1.getTime()));
                System.out.printf("Friday #%d: %s\n",numberOfFri,df1.format(pc1.getTime()));
                pc1.add(PersianCalendar.DATE,7);
            } else
                pc1.add(PersianCalendar.DATE,1);
        }
        return numberOfFri;
    }

    public int findThursday() { // must be private
        setPersianDate();

        int numberOfThu = 0;
        while (!pc1.after(pc2)) {
            if (pc1.get(com.ibm.icu.util.Calendar.DAY_OF_WEEK) == PersianCalendar.THURSDAY) {
                numberOfThu++;
                pc1.add(PersianCalendar.DATE,7); // 7 days later
            } else
                pc1.add(PersianCalendar.DATE,1);
        }
        return numberOfThu;
    }

    public int findWednesday() { // must be private
        setPersianDate();

        int numberOfWed = 0;
        while (!pc1.after(pc2)) {
            if (pc1.get(Calendar.DAY_OF_WEEK) == PersianCalendar.THURSDAY) {
                numberOfWed++;
                pc1.add(PersianCalendar.DATE,7); // 7 days later
            } else
                pc1.add(PersianCalendar.DATE,1);
        }
        return numberOfWed;
    }
}
