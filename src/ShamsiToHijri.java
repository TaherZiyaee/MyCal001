import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.IslamicCalendar;
import org.omg.PortableInterceptor.InvalidSlot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class ShamsiToHijri {

    private GregorianCalendar gc1 = new GregorianCalendar();
    private GregorianCalendar gc2 = new GregorianCalendar();
    private IslamicCalendar ic1 = new IslamicCalendar();
    private IslamicCalendar ic2 = new IslamicCalendar();
    private ArrayList<IslamicCalendar> isCal = new ArrayList<>();

    public ShamsiToHijri() {
        shamsiToMiladi();
        miladiToHijri();
        defineIslamicHolidays();
    }

    /*public Date shamsiToMiladi() {

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        PersianCalendar persianCalendar = new PersianCalendar(new Date());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(persianCalendar.getTime());

        System.out.println(String.valueOf(df.format(gregorianCalendar.getTime())));

        return gregorianCalendar.getTime();
    }*/

    // done
    public void shamsiToMiladi() {

        MyDate01 myDate01 = new MyDate01();
        PersianCalendar pc1 = (PersianCalendar) myDate01.getPc1();
        PersianCalendar pc2 = (PersianCalendar) myDate01.getPc2();

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        gc1.setTime(pc1.getTime());
        gc2.setTime(pc2.getTime());

//        System.out.println(String.valueOf(df.format(gc1.getTime())));
//        System.out.println(String.valueOf(df.format(gc2.getTime())));

    }

    /*public void miladiToHijri() {
        IslamicCalendar islamicCalendar = new IslamicCalendar();
//        islamicCalendar.set(Calendar.MONTH,IslamicCalendar.RABI_2);
        islamicCalendar.setTime(gc1.getTime());

//        System.out.println("Islamic: " + String.valueOf(islamicCalendar.getTime()));

        System.out.printf("YEAR: %d\n",islamicCalendar.get(IslamicCalendar.YEAR));
        System.out.printf("MONTH: %d\n",islamicCalendar.get(IslamicCalendar.MONTH)+1);
        System.out.printf("DAY: %d\n",islamicCalendar.get(IslamicCalendar.DATE)-1);
    }*/

    // done
    public void miladiToHijri() {
//        islamicCalendar.set(Calendar.MONTH,IslamicCalendar.RABI_2);
        ic1.setTime(gc1.getTime());
        ic2.setTime(gc2.getTime());

        System.out.printf("Start Date: %d/%d/%d\n",ic1.get(IslamicCalendar.YEAR),ic1.get(IslamicCalendar.MONTH),ic1.get(IslamicCalendar.DATE));
        System.out.printf("End Date: %d/%d/%d\n",ic2.get(IslamicCalendar.YEAR),ic2.get(IslamicCalendar.MONTH),ic2.get(IslamicCalendar.DATE));
    }


    public void printHijriDate() {
        IslamicCalendar islamicCalendar = new IslamicCalendar();
        islamicCalendar.set(1441,IslamicCalendar.SHAWWAL,11);
        System.out.println(String.valueOf(islamicCalendar.getTime()));
    }

    public void defineIslamicHolidays() {
        MyDate01 myDate01 = new MyDate01();
        int year =  myDate01.getCurrentHijriYear();

        isCal.add(new IslamicCalendar(year,IslamicCalendar.MUHARRAM,9));    // ۸ شهریور تاسوعای حسینی [ ٩ محرم ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.MUHARRAM,10));   //  ۹ شهریور عاشورای حسینی [ ١٠ محرم ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SAFAR,20));  //  ۱۷ مهر اربعین حسینی [ ٢٠ صفر ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SAFAR,28));  //  ۲۵ مهر رحلت رسول اکرم؛شهادت امام حسن مجتبی علیه السلام [ ٢٨ صفر ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SAFAR,29));  //  ۲۶ مهر شهادت امام رضا علیه السلام [ ٢٩ صفر ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.RABI_1,8));  //   ۴ آبان شهادت امام حسن عسکری علیه السلام [ ٨ ربيع الاول ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.RABI_1,17));  //  ۱۳ آبان میلاد رسول اکرم و امام جعفر صادق علیه السلام [ ١٧ ربيع الاول ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.JUMADA_2,3));  //  ۲۸ دی شهادت حضرت فاطمه زهرا سلام الله علیها [ ٣ جمادي الثانيه ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.RAJAB,13));  //  ۷ اسفند ولادت امام علی علیه السلام و روز پدر [ ١٣ رجب ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.RAJAB,27));  //  ۲۱ اسفند مبعث رسول اکرم (ص) [ ٢٧ رجب ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SHABAN,15));  //  ۹ فروردین ولادت حضرت قائم عجل الله تعالی فرجه و جشن نیمه شعبان [ ١٥ شعبان ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.RAMADAN,21));  //  ۱۴ اردیبهشت شهادت حضرت علی علیه السلام [ ٢١ رمضان ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SHAWWAL,1));  //  ۲۳ اردیبهشت عید سعید فطر [ ١ شوال ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SHAWWAL,2));  //  ۲۴ اردیبهشت تعطیل به مناسبت عید سعید فطر [ ٢ شوال ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.SHAWWAL,25));  //  ۱۶ خرداد شهادت امام جعفر صادق علیه السلام [ ٢٥ شوال ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.DHU_AL_HIJJAH,10));  //  ۳۰ تیر عید سعید قربان [ ١٠ ذوالحجه ]
        isCal.add(new IslamicCalendar(year,IslamicCalendar.DHU_AL_HIJJAH,18));  //  ۷ اَمرداد عید سعید غدیر خم [ ١٨ ذوالحجه ]
    }

    // Calculate shamsi holidays - done
    public int islamicHolidaysHours() {

        int wedHoliday = 0, first4DaysHoliday = 0;

//        ic1.add(IslamicCalendar.DATE,-1);
        while (!ic1.after(ic2)) {
            for (int i=0; i<isCal.size(); i++) {
                if (ic1.get(Calendar.MONTH) == isCal.get(i).get(Calendar.MONTH)) {
                    if (ic1.get(Calendar.DAY_OF_MONTH) == isCal.get(i).get(Calendar.DAY_OF_MONTH)) {
                        int dayOfWeek = ic1.get(Calendar.DAY_OF_WEEK);
                        if (dayOfWeek != Calendar.FRIDAY && dayOfWeek != Calendar.THURSDAY)
                            if (dayOfWeek == Calendar.WEDNESDAY) {
                                wedHoliday++;
                            } else {
                                first4DaysHoliday++;
                            }
                    }
                }
            }
            ic1.add(IslamicCalendar.DATE, 1);
        }

        int result = (wedHoliday * 8) + (first4DaysHoliday * 9);
        return result;
    }
}
