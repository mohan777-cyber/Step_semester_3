package week8_assignment;

import java.util.*;

abstract class Vehicle {
    int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }
    double calculateCharge() { return hours * 10; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }
    double calculateCharge() { return 30 + (hours - 1) * 20; }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }
    double calculateCharge() { return Math.max(100, hours * 50); }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            int hrs = sc.nextInt();
            Vehicle v = null;

            switch (type) {
                case "BIKE": v = new Bike(hrs); break;
                case "CAR": v = new Car(hrs); break;
                case "TRUCK": v = new Truck(hrs); break;
            }

            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

