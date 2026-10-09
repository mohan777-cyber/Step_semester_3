package week9.Practice_Practice;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    // Every connection must implement its own billing logic
    public abstract double calculateBill();

    public abstract String getType();
}

// Home connection
class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

// Shop connection
class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8) + 100; // fixed charge
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

// Factory connection
class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6;
        return Math.max(bill, 1000); // minimum bill
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.println(c.getType() + ": " + df.format(bill));
            total += bill;
        }

        System.out.println("Total: " + df.format(total));
    }
}

