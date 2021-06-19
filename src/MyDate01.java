import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MyDate01 {

    PersianCalendar pc;
    GregorianCalendar gc;

    public static void convertSHtoMIL() {

        PersianCalendar pc = new PersianCalendar();
        pc.set(1400, PersianCalendarConstants.ORDIBEHESHT,21);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(pc.getTime());

//        System.out.printf("Julian Date: %s\n",gc.getTime().toString());
        System.out.printf("Julian Date: %s\n",new MyDate01().setFormat(gc));
    }

    private String setFormat(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }
}
