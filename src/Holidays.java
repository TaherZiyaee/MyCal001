import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ghasemkiani.util.icu.PersianDateFormat;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import java.util.ArrayList;

import static com.ghasemkiani.util.PersianCalendarConstants.KHORDAD;

public class Holidays {

    public enum PersianHolidays {

        // KHORDAD
        Rehlat_Emam(KHORDAD,15),
        Qiyam_15_Khordad(KHORDAD,16);

        private int month;
        private int day;

        PersianHolidays(int month, int day) {
            this.month = month;
            this.day = day;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }
    }

    public void printValue() {
        System.out.println(PersianHolidays.Rehlat_Emam.getMonth());
        System.out.println(PersianHolidays.Rehlat_Emam.getDay());
    }

    public void setPersianHolidays() {
        DateFormat df = new PersianDateFormat("yyyy/MM/dd");
        Calendar cal = PersianCalendar.getInstance();
        ArrayList<Calendar>  pHolidays = new ArrayList<>();
        cal.set(1400,KHORDAD,15);
        pHolidays.add(cal);
        cal.set(1400,KHORDAD,16);
        pHolidays.add(cal);

        SimpleDateFormat sdf = new PersianDateFormat("yyyy-MM/dd");


    }
}
