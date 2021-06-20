
public class MyMain {
    public static void main(String[] args) {
        MyDate01 myDate01 = new MyDate01();

        myDate01.printPersianDates();
        myDate01.convertSHtoMIL();

//        System.out.println("Fridays number: " + myDate01.findFriday());

//        System.out.printf("Thursday number: %d\n",myDate01.findThursday());

        System.out.printf("Wednesday number: %d\n",myDate01.findWednesday());
    }
}
