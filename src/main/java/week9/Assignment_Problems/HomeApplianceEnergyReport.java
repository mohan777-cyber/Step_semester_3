package week9.Assignment_Problems;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Appliance {
    protected int hours;
    protected boolean saverMode;
    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(int hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    // Each appliance defines its own power rating
    public abstract double powerRating();

    // By default, appliances do not support saver mode
    public boolean supportsSaverMode() {
        return false;
    }

    public double calculateUnits() {
        double units = (powerRating() * hours) / 1000.0;
        if (saverMode) {
            if (!supportsSaverMode()) {
                return -1; // signal unsupported saver mode
            }
            units = units * 0.75; // reduce by 25%
        }
        return units;
    }

    public double calculateCost() {
        double units = calculateUnits();
        if (units == -1) return -1;
        return units * COST_PER_UNIT;
    }

    public abstract String getType();
}

// Fridge
class Fridge extends Appliance {
    public Fridge(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double powerRating() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }
}

// Air Conditioner
class AC extends Appliance {
    public AC(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double powerRating() {
        return 1500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

// TV
class TV extends Appliance {
    public TV(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double powerRating() {
        return 100.0;
    }

    @Override
    public String getType() {
        return "TV";
    }
}

// Washing Machine
class Washer extends Appliance {
    public Washer(int hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double powerRating() {
        return 500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }

    @Override
    public String getType() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            boolean saverMode = parts.length == 3 && parts[2].equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances.add(new Fridge(hours, saverMode));
                    break;
                case "AC":
                    appliances.add(new AC(hours, saverMode));
                    break;
                case "TV":
                    appliances.add(new TV(hours, saverMode));
                    break;
                case "WASHER":
                    appliances.add(new Washer(hours, saverMode));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double totalCost = 0;

        for (Appliance a : appliances) {
            double units = a.calculateUnits();
            double cost = a.calculateCost();

            if (units == -1) {
                System.out.println(a.getType() + ": saver mode not supported");
            } else {
                System.out.println(a.getType() + ": Units=" + df.format(units) +
                        " Cost=" + df.format(cost));
                totalCost += cost;
            }
        }

        System.out.println("Total Cost: " + df.format(totalCost));
    }
}

