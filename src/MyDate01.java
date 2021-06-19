import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MyDate01 {

    private PersianCalendar pc;
    private GregorianCalendar gc;

    public void setPc(PersianCalendar pc) {
        pc.set(1400, PersianCalendarConstants.ORDIBEHESHT,21);
        this.pc = pc;
    }

    public PersianCalendar getPc() {
        return pc;
    }

    public void convertSHtoMIL() {

//        PersianCalendar pc = new PersianCalendar();
//        pc.set(1400, PersianCalendarConstants.ORDIBEHESHT,21);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getPc().getTime());

//        System.out.printf("Julian Date: %s\n",gc.getTime().toString());
        System.out.printf("Julian Date: %s\n",new MyDate01().setFormat(gc));
    }

    private String setFormat(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    private int findFriday() {

    }
}
