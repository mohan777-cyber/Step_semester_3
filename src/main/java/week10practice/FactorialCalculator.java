package week10practice;

public class FactorialCalculator {

    public static void main(String[] args) {
        int num1 = 5;  // Sample input 1
        int num2 = 0;  // Sample input 2

        System.out.println(factorial(num1)); // Expected output: 120
        System.out.println(factorial(num2)); // Expected output: 1
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

