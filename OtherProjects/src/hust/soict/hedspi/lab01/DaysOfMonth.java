

import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Input month: ");
            String month = keyboard.nextLine();
            System.out.println("Input year: ");
            int year = keyboard.nextInt();
            switch (month) {
                case "January":
                case "Jan.":
                case "Jan":
                case "1":
                    System.out.println("January " + year + " has 31 days");
                    break;
                case "February":
                case "Feb.":
                case "Feb":
                case "2":
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                        System.out.println("February " + year + " has 29 days");
                    else
                        System.out.println("February " + year + " has 28 days");
                    break;
                case "March":
                case "Mar.":
                case "Mar":
                case "3":
                    System.out.println("March " + year + " has 31 days");
                    break;
                case "April":
                case "Apr.":
                case "Apr":
                case "4":
                    System.out.println("April " + year + " has 30 days");
                    break;
                case "May":
                case "5":
                    System.out.println("May " + year + " has 31 days");
                    break;
                case "June":
                case "Jun.":
                case "Jun":
                case "6":
                    System.out.println("June " + year + " has 30 days");
                    break;
                case "July":
                case "Jul.":
                case "Jul":
                case "7":
                    System.out.println("July " + year + " has 31 days");
                    break;
                case "August":
                case "Aug.":
                case "Aug":
                case "8":
                    System.out.println("August " + year + " has 31 days");
                    break;
                case "September":
                case "Sep.":
                case "Sep":
                case "9":
                    System.out.println("September " + year + " has 30 days");
                    break;
                case "October":
                case "Oct.":
                case "Oct":
                case "10":
                    System.out.println("October " + year + " has 31 days");
                    break;
                case "November":
                case "Nov.":
                case "Nov":
                case "11":
                    System.out.println("November " + year + " has 30 days");
                    break;
                case "December":
                case "Dec.":
                case "Dec":
                case "12":
                    System.out.println("December " + year + " has 31 days");
                    break;
                default:
                    System.out.println("Invalid month");
            }
        }
    }

}
