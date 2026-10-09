package week9.Assignment_Problems;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.0; // centralized transport fee

    public Student(String name) {
        this.name = name;
    }

    // Every student must implement tuition/hostel/scholarship logic
    public abstract double baseFee();

    // By default, students do not use the bus
    public boolean usesBus() {
        return false;
    }

    public double totalFee() {
        double fee = baseFee();
        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

// Day Scholar
class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double baseFee() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

// Hosteller
class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double baseFee() {
        return 40000.0 + 60000.0; // tuition + hostel fee
    }
}

// Scholarship Student
class Scholar extends Student {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double baseFee() {
        return 20000.0; // half tuition
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(name));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double totalCollected = 0;

        for (Student s : students) {
            double fee = s.totalFee();
            System.out.println(s.name + ": " + df.format(fee));
            totalCollected += fee;
        }

        System.out.println("Total Collected: " + df.format(totalCollected));
    }
}
