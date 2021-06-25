import com.ghasemkiani.util.DateFields;
import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ghasemkiani.util.icu.PersianDateFormat;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;


import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyDate01 {

    final int holiday = 2;
    private com.ibm.icu.util.Calendar pc1 = new PersianCalendar(new Date());
    private com.ibm.icu.util.Calendar pc2 = new PersianCalendar(new Date());

    public Calendar getPc1() {
        return pc1;
    }

    public void setPc1(Calendar pc1) {
        this.pc1 = pc1;
    }

    public Calendar getPc2() {
        return pc2;
    }

    public void setPc2(Calendar pc2) {
        this.pc2 = pc2;
    }

    private void setPersianDate() {
        pc1.set(1400, PersianCalendarConstants.KHORDAD,1);
        pc2.set(1400,PersianCalendarConstants.KHORDAD,31);
    }

    public void printPersianDate() {
//        Date date = pc1.getTime();
        DateFields date = pc1.getTime();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = df.format(date);
        System.out.println("Converted String: " + strDate);
    }

    public int findFriday() {   // must be private
        setPersianDate();

        Locale loc = new Locale("FA","IR");
        DateFormat df = PersianDateFormat.getDateInstance(pc1,PersianDateFormat.DEFAULT,loc);

        int numberOfFri = 0;
        while (!pc1.after(pc2)) {
            if (pc1.get(PersianCalendar.DAY_OF_WEEK) == PersianCalendar.FRIDAY) {
                numberOfFri++;
//                System.out.printf("Friday #%d: %s\n",numberOfFri,df.format(pc1.getTime()));
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

    public int countDays() {
        setPersianDate();

        int numberOfDays = 0;
        while (!pc1.after(pc2)) {
            numberOfDays++;
            pc1.add(PersianCalendar.DATE, 1); // 1 days later
        }
        return numberOfDays;
    }

    public LocalDate hijriToGregorian() {
        HijrahDate date = HijrahChronology.INSTANCE.dateNow();
        date.getChronology().date(1442,11,13);
        System.out.println(date);

        LocalDate gDate = IsoChronology.INSTANCE.date(date);
        System.out.println(gDate);

        int year = gDate.getYear();
//        String month = String.valueOf(gDate.getMonth());
        int month = gDate.getMonthValue();
        int day = gDate.getDayOfMonth();
        System.out.printf("Y: %d, M: %d, D: %d\n",year,month,day);

        return gDate;
    }

    public void gregorianToShamsi() {

    }

    public void findDayBetween() {
        setPersianDate();
        Calendar cal = new PersianCalendar();
        cal.set(1400,PersianCalendarConstants.KHORDAD,11);
        String condition = "Not OK";

        while (!pc1.after(pc2)) {
            if (pc1.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
            pc1.get(Calendar.MONTH) == cal.get(Calendar.MONTH) &&
            pc1.get(Calendar.DAY_OF_MONTH) == cal.get(Calendar.DAY_OF_MONTH)) {
                condition = "OK";
                System.out.println(condition);
                return;
            }
            else
                pc1.add(PersianCalendar.DATE,1);
        }
        System.out.println(condition);
    }

    public void compareDates() {
        java.util.Calendar cal1 = new GregorianCalendar(2020,9,10);
        java.util.Calendar cal2 = new GregorianCalendar(2020,9,10);

        int i = cal1.compareTo(cal2);
        int j = cal2.compareTo(cal1);

        System.out.println(i);
        System.out.println(j);
    }


}
