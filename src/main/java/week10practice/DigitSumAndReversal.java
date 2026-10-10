package week10practice;

public class DigitSumAndReversal {

    public static void main(String[] args) {
        int number = 4721; // Sample input

        calculateDigitSumAndReverse(number);
    }

    public static void calculateDigitSumAndReverse(int number) {
        int sum = 0;
        int reversed = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;   // extract last digit
            sum += digit;            // add to sum
            reversed = reversed * 10 + digit; // build reversed number
            temp /= 10;              // remove last digit
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}

