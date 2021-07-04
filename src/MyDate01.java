import com.ghasemkiani.util.DateFields;
import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.SimplePersianCalendar;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ghasemkiani.util.icu.PersianDateFormat;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.IslamicCalendar;
import org.omg.PortableInterceptor.InvalidSlot;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyDate01 {

    private int pMonth;
//    private ArrayList<PersianCalendar> persianArrayList = new ArrayList<>();
    private ArrayList<String> pDateArrayList = new ArrayList<>();
    private ArrayList<PersianCalendar> pCalendarsArrayList = new ArrayList<>();
    private PersianCalendar pCal = new PersianCalendar();
    private com.ibm.icu.util.Calendar pc1 = new PersianCalendar(new Date());
    private com.ibm.icu.util.Calendar pc2 = new PersianCalendar(new Date());

    // Constructor
    public MyDate01() {
        whichMonth();
    }

    public int getpMonth() {
        return pMonth;
    }

    public void setpMonth(int pMonth) {
        this.pMonth = pMonth;
    }

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

    // get current persian year - done
    private int getCurrentYear() {
        PersianCalendar currentDate = new PersianCalendar(new Date());
        int currentYear = currentDate.get(PersianCalendar.YEAR);
        return currentYear;
    }

    // get current hijri year - done
    private int getCurrentHijriYear() {
        IslamicCalendar currentHDate = new IslamicCalendar(new Date());
        int currentHYear = currentHDate.get(IslamicCalendar.YEAR);
        return currentHYear;
    }

    // set persian date for each month - done
    private void setRangOfPMonth() {

        int year = getCurrentYear();

        switch (getpMonth()) {
            // Spring
            case PersianCalendarConstants.FARVARDIN:
                pc1.set(year-1,PersianCalendarConstants.ESFAND,21);
                pc2.set(year,PersianCalendarConstants.FARVARDIN,20);
                break;
            case PersianCalendarConstants.ORDIBEHESHT:
                pc1.set(year,PersianCalendarConstants.FARVARDIN,21);
                pc2.set(year,PersianCalendarConstants.ORDIBEHESHT,20);
                break;
            case PersianCalendarConstants.KHORDAD:
                pc1.set(year,PersianCalendarConstants.ORDIBEHESHT,21);
                pc2.set(year,PersianCalendarConstants.KHORDAD,20);
                break;
            // Summer
            case PersianCalendarConstants.TIR:
                pc1.set(year,PersianCalendarConstants.KHORDAD,21);
                pc2.set(year,PersianCalendarConstants.TIR,20);
                break;
            case PersianCalendarConstants.MORDAD:
                pc1.set(year,PersianCalendarConstants.TIR,21);
                pc2.set(year,PersianCalendarConstants.MORDAD,20);
                break;
            case PersianCalendarConstants.SHAHRIVAR:
                pc1.set(year,PersianCalendarConstants.MORDAD,21);
                pc2.set(year,PersianCalendarConstants.SHAHRIVAR,20);
                break;
            // Autumn
            case PersianCalendarConstants.MEHR:
                pc1.set(year,PersianCalendarConstants.SHAHRIVAR,21);
                pc2.set(year,PersianCalendarConstants.MEHR,20);
                break;
            case PersianCalendarConstants.ABAN:
                pc1.set(year,PersianCalendarConstants.MEHR,21);
                pc2.set(year,PersianCalendarConstants.ABAN,20);
                break;
            case PersianCalendarConstants.AZAR:
                pc1.set(year,PersianCalendarConstants.ABAN,21);
                pc2.set(year,PersianCalendarConstants.AZAR,20);
                break;
            // Winter
            case PersianCalendarConstants.DEY:
                pc1.set(year,PersianCalendarConstants.AZAR,21);
                pc2.set(year,PersianCalendarConstants.DEY,20);
                break;
            case PersianCalendarConstants.BAHMAN:
                pc1.set(year,PersianCalendarConstants.DEY,21);
                pc2.set(year,PersianCalendarConstants.BAHMAN,20);
                break;
            case PersianCalendarConstants.ESFAND:
                pc1.set(year,PersianCalendarConstants.BAHMAN,21);
                pc2.set(year,PersianCalendarConstants.ESFAND,20);
                break;
        }
    }

    // selected month - done
    private void whichMonth() {
        setpMonth(PersianCalendarConstants.FARVARDIN);
    }

    public void printPersianDate() {
        Date date = pc1.getTime();
//        DateFields date = pc1.getTime();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = df.format(date);
        System.out.println("Converted String: " + strDate);
    }

    // Specify the number of Fridays in a month - done
    private int findFriday() {

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

    // Specify the number of Thursday in a month - done
    private int findThursday() {

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

    // Specify the number of Wednesday in a month - done
    private int findWednesday() {

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

    // Calculate the number of days in the month - done
    private int countDays() {

        int numberOfDays = 0;
        while (!pc1.after(pc2)) {
            numberOfDays++;
            pc1.add(PersianCalendar.DATE, 1); // 1 days later
        }
        return numberOfDays;
    }

    // Convert Hijri calendar to Gregorian calendar and plus 1 date to it - done
    public Date hijriToGregorian() {
        IslamicCalendar hijri = new IslamicCalendar();
        hijri.set(1444, IslamicCalendar.DHU_AL_HIJJAH,23);
        System.out.println(String.valueOf(hijri.getTime()));
        GregorianCalendar gregorian = new GregorianCalendar();
        gregorian.setTime(hijri.getTime());
        gregorian.add(GregorianCalendar.DATE,1);

        /*int gYear = gregorian.get(GregorianCalendar.YEAR);
        int gMonth = gregorian.get(GregorianCalendar.MONTH);
        int gDay = gregorian.get(GregorianCalendar.DAY_OF_MONTH);
        System.out.println(gMonth);
        System.out.println(gDay);*/
        return gregorian.getTime();
    }

    // Convert Gregorian calendar to Persian calendar- done
    public void gregorianToShamsi() {
        Date gDate = hijriToGregorian();
        PersianCalendar cal = new PersianCalendar();
        cal.setTime(gDate);

        System.out.println("--------------");
        System.out.println(cal.get(PersianCalendar.YEAR));
        System.out.println(cal.get(PersianCalendar.MONTH));
        System.out.println(cal.get(PersianCalendar.DAY_OF_MONTH));
    }

    public void findDayBetween() {
//        setPersianDate();
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

    public void definePersianHolidays() {
        pCalendarsArrayList.clear();

        int year = getCurrentYear();

        switch (getpMonth()) {
            case PersianCalendarConstants.FARVARDIN:
                pCalendarsArrayList.add(new PersianCalendar(year-1,PersianCalendarConstants.ESFAND,29)); //  ۲۹ اسفند روز ملی شدن صنعت نفت ایران
                pCalendarsArrayList.add(new PersianCalendar(year-1,PersianCalendarConstants.ESFAND,30)); //   ۳۰ اسفند آخرین روز سال
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,1)); //  ۱ فروردین جشن نوروز/جشن سال نو
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,2)); //  ۲ فروردین عیدنوروز
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,3)); //  ۳ فروردین عیدنوروز
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,4)); //  ۴ فروردین عیدنوروز
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,12)); //   ۱۲ فروردین روز جمهوری اسلامی
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.FARVARDIN,13)); //  ۱۳ فروردین جشن سیزده به در
                break;
            case PersianCalendarConstants.KHORDAD:
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.KHORDAD,14)); //  ۱۴ خرداد رحلت حضرت امام خمینی
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.KHORDAD,15)); //  ۱۵ خرداد قیام 15 خرداد
                break;
            case PersianCalendarConstants.ESFAND:
                pCalendarsArrayList.add(new PersianCalendar(year,PersianCalendarConstants.BAHMAN,22)); //۲۲ بهمن پیروزی انقلاب اسلامی
                break;
        }

        /*System.out.println(pCalendarsArrayList.get(0).get(Calendar.YEAR));
        System.out.println(pCalendarsArrayList.get(0).get(Calendar.MONTH));
        System.out.println(pCalendarsArrayList.get(0).get(Calendar.DAY_OF_MONTH));

        System.out.println(pCalendarsArrayList.get(0).get(Calendar.DAY_OF_WEEK));*/
    }

    public void defineHijriHolidays() {
        int year = getCurrentHijriYear();
        ArrayList<IslamicCalendar> hijriArrayList = new ArrayList<>();
        IslamicCalendar hijri = new IslamicCalendar();
//        hijriArrayList.add(new IslamicCalendar(year,));
    }

    public void simplePC() {
        SimplePersianCalendar spc = new SimplePersianCalendar();
        DateFields t = spc.getDateFields();
        System.out.printf("Current date in persian calensar is: %d/%d/%d\n",t.getYear(),t.getMonth()+1,t.getDay());
    }


}
