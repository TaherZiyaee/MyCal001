
public class MyMain {
    public static void main(String[] args) {
        MyDate01 myDate01 = new MyDate01();
        Holidays holidays = new Holidays();

//        System.out.println("Fridays#: " + myDate01.findFriday());
//        System.out.println("Thursday#: " + myDate01.findThursday());
//        System.out.println("Wednesday#: " + myDate01.findWednesday());
//        System.out.println("All Days: " + myDate01.countDays());

        myDate01.printPersianDate();

//        myDate01.findDayBetween();

        myDate01.compareDates();

//        myDate01.hijriToGregorian();

//        holidays.printValue();

        holidays.setPersianHolidays();


    }
}
