package week9.Assignment_Problems;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class for all parcels
abstract class Parcel {
    protected int weightKg;
    protected double declaredValue;

    public Parcel(int weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    // Every parcel must implement its charge calculation
    public abstract double calculateCharge();

    // By default, parcels are not insurable
    public double calculateInsurance() {
        return 0.0;
    }

    public double total() {
        return calculateCharge() + calculateInsurance();
    }

    public abstract String getType();
}

// Interface for insurable parcels
interface Insurable {
    double calculateInsurance();
}

// Standard parcel (not insurable)
class StandardParcel extends Parcel {
    public StandardParcel(int weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40 + (10 * weightKg);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

// Express parcel (insurable)
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(int weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80 + (15 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

// Fragile parcel (insurable)
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(int weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return (40 + (10 * weightKg)) + 50; // standard charge + handling fee
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int weight = Integer.parseInt(parts[1]);
            double value = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, value));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, value));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, value));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double grandTotal = 0;

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.calculateInsurance();
            double total = p.total();

            System.out.println(p.getType() + ": Charge=" + df.format(charge) +
                    " Insurance=" + df.format(insurance) +
                    " Total=" + df.format(total));
            grandTotal += total;
        }

        System.out.println("Grand Total: " + df.format(grandTotal));
    }
}
