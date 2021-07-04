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

    public void defineIslamicHolidays() {
        MyDate01 myDate01 = new MyDate01();
        int year =  myDate01.getCurrentHijriYear();

        ArrayList<IslamicCalendar> isCal = new ArrayList<>();
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
}
