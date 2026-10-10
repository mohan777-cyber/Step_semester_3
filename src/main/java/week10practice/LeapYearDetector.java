package week10practice;

public class LeapYearDetector {

    public static void main(String[] args) {
        int year1 = 2024; // Sample input 1
        int year2 = 1900; // Sample input 2
        int year3 = 2000; // Sample input 3

        checkLeapYear(year1);
        checkLeapYear(year2);
        checkLeapYear(year3);
    }

    public static void checkLeapYear(int year) {
        // Leap year rule:
        // Divisible by 4 → leap year
        // Except divisible by 100 → not leap year
        // Unless divisible by 400 → leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }
}
