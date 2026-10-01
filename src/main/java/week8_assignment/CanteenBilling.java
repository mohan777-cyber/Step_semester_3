package week8_assignment;

import java.util.*;

abstract class Customer {
    double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.9; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }
    double calculateFinalAmount() { return amount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Customer c = null;

            switch (type) {
                case "STUDENT": c = new Student(amt); break;
                case "STAFF": c = new Staff(amt); break;
                case "GUEST": c = new Guest(amt); break;
            }

            double finalAmt = c.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

