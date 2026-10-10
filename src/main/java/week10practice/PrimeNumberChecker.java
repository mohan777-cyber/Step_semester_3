package week10practice;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        int num1 = 29; // Sample input 1
        int num2 = 21; // Sample input 2

        checkPrime(num1);
        checkPrime(num2);
    }

    public static void checkPrime(int number) {
        if (number <= 1) {
            System.out.println(number + " is not prime (must be > 1)");
            return;
        }

        boolean isPrime = true;

        // Only check up to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is prime");
        } else {
            System.out.println(number + " is not prime");
        }
    }
}
