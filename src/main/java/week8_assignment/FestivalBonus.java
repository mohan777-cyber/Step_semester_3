package week8_assignment;

import java.util.*;

abstract class Employee {
    String name;
    double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }
    abstract double calculateBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    double calculateBonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    double calculateBonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double calculateBonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee e = null;

            switch (type) {
                case "FULLTIME": e = new FullTime(name, salary); break;
                case "PARTTIME": e = new PartTime(name, salary); break;
                case "INTERN": e = new Intern(name, salary); break;
            }

            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
