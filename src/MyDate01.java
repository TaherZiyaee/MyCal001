import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MyDate01 {

    private PersianCalendar pc;
    private GregorianCalendar gc;

    public void setPc(PersianCalendar pc) {
        this.pc = pc;
    }

    public PersianCalendar getPc() {
        return pc;
    }

    public GregorianCalendar getGc() {
        return gc;
    }

    public void setGc(GregorianCalendar gc) {
        this.gc = gc;
    }

    public void convertSHtoMIL() {

        setPc(new PersianCalendar(1400, PersianCalendarConstants.ORDIBEHESHT,21));


        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getPc().getTime());
        setGc(gc);


//        System.out.printf("Julian Date: %s\n",gc.getTime().toString());
        System.out.printf("Julian Date: %s\n",new MyDate01().setFormat(gc));
    }

    private String setFormat(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    private void defineRange(GregorianCalendar start, GregorianCalendar end) {

    }

    private int findFriday() {
        return 0;
    }
}
