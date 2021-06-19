import com.ghasemkiani.util.PersianCalendarConstants;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MyDate01 {

    private PersianCalendar pc;
    private GregorianCalendar gc;

    private void setPc(PersianCalendar pc) {
        this.pc = pc;
    }

    private PersianCalendar getPc() {
        return pc;
    }

    private GregorianCalendar getGc() {
        return gc;
    }

    private void setGc(GregorianCalendar gc) {
        this.gc = gc;
    }

    private void definePersianRange(PersianCalendar pc1,PersianCalendar pc2) {

        pc1.set(1400,PersianCalendarConstants.ORDIBEHESHT,21);

    }

    public void convertSHtoMIL() {

        setPc(new PersianCalendar(1400, PersianCalendarConstants.ORDIBEHESHT,21));

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getPc().getTime());
        setGc(gc);

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
