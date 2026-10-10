package week10practice;

public class EvenOddCounter {

    public static void main(String[] args) {
        int[] numbers = {3, 8, 12, 5, 7, 10}; // Sample input
        countEvenOdd(numbers);
    }

    public static void countEvenOdd(int[] numbers) {
        int evenCount = 0, oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
