import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.IslamicCalendar;
import org.omg.PortableInterceptor.InvalidSlot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShamsiToHijri {

    public Date shamsiToMiladi() {

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        PersianCalendar persianCalendar = new PersianCalendar(new Date());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(persianCalendar.getTime());

        System.out.println(String.valueOf(df.format(gregorianCalendar.getTime())));

        return gregorianCalendar.getTime();
    }

    public void miladiToHijri() {
        IslamicCalendar islamicCalendar = new IslamicCalendar();
        islamicCalendar.set(Calendar.MONTH,IslamicCalendar.RABI_2);
//        islamicCalendar.setTime(shamsiToMiladi());

//        System.out.println("Islamic: " + String.valueOf(islamicCalendar.getTime()));

        System.out.printf("YEAR: %d\n",islamicCalendar.get(IslamicCalendar.YEAR));
        System.out.printf("MONTH: %d\n",islamicCalendar.get(IslamicCalendar.MONTH)+1);
        System.out.printf("DAY: %d\n",islamicCalendar.get(IslamicCalendar.DATE)-1);
    }

    // done
    public void printHijriDate() {
        IslamicCalendar islamicCalendar = new IslamicCalendar();
        islamicCalendar.set(1441,IslamicCalendar.SHAWWAL,11);
        System.out.println(String.valueOf(islamicCalendar.getTime()));
    }
}
