package week9.Practice_Practice;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    // Every staff type must implement its own pay calculation
    public abstract double calculatePay();
}

// Full-time staff
class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

// Hourly staff
class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

// Interns
class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyPayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];

            switch (type) {
                case "FULLTIME":
                    staffList.add(new FullTimeStaff(name, Double.parseDouble(parts[2])));
                    break;
                case "HOURLY":
                    staffList.add(new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
                case "INTERN":
                    staffList.add(new Intern(name, Double.parseDouble(parts[2])));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Staff s : staffList) {
            double pay = s.calculatePay();
            System.out.println(s.name + ": " + df.format(pay));
            total += pay;
        }

        System.out.println("Total Payroll: " + df.format(total));
    }
}
