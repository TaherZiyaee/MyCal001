import java.text.ParseException;

public class MyMain {
    public static void main(String[] args) throws ParseException {
        MyDate01 myDate01 = new MyDate01();
        Holidays holidays = new Holidays();
        ShamsiToHijri shamsiToHijri = new ShamsiToHijri();

//        System.out.println("Fridays#: " + myDate01.findFriday());
//        System.out.println("Thursday#: " + myDate01.findThursday());
//        System.out.println("Wednesday#: " + myDate01.findWednesday());
//        System.out.println("All Days: " + myDate01.countDays());

//        myDate01.printPersianDate();

//        System.out.println(myDate01.findWednesday());
//        System.out.println(myDate01.findFriday());

//        myDate01.findDayBetween();

//        myDate01.compareDates();

//        myDate01.hijriToGregorian();

//        holidays.printValue();

//        holidays.setPersianHolidays();

//        myDate01.gregorianToShamsi();

//        myDate01.definePersianHolidays();

//        myDate01.simplePC();

//        System.out.println(myDate01.getCurrentHijriYear());

        shamsiToHijri.shamsiToMiladi();
        shamsiToHijri.miladiToHijri();

//        shamsiToHijri.printHijriDate();

//        shamsiToHijri.defineIslamicHolidays();

//        myDate01.calculation();

//        System.out.println(myDate01.persianHolidaysHours());
    }
}
