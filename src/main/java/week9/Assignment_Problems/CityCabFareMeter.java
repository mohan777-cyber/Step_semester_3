package week9.Assignment_Problems;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Cab {
    protected int km;
    protected String time; // DAY or NIGHT
    protected static final double MINIMUM_FARE = 100.0;

    public Cab(int km, String time) {
        this.km = km;
        this.time = time;
    }

    // Each cab defines its own rate per km
    public abstract double ratePerKm();

    // By default, cabs do not offer night service
    public boolean offersNightService() {
        return false;
    }

    public double calculateFare() {
        double fare = km * ratePerKm();
        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }
        if (time.equals("NIGHT")) {
            if (!offersNightService()) {
                return -1; // signal rejection
            }
            fare = fare * 1.2; // add 20% for night
        }
        return fare;
    }

    public abstract String getType();
}

// Mini cab
class MiniCab extends Cab {
    public MiniCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double ratePerKm() {
        return 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }
}

// Sedan cab
class SedanCab extends Cab {
    public SedanCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double ratePerKm() {
        return 14.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}

// SUV cab
class SUVCab extends Cab {
    public SUVCab(int km, String time) {
        super(km, time);
    }

    @Override
    public double ratePerKm() {
        return 18.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Cab> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int km = Integer.parseInt(parts[1]);
            String time = parts[2];

            switch (type) {
                case "MINI":
                    trips.add(new MiniCab(km, time));
                    break;
                case "SEDAN":
                    trips.add(new SedanCab(km, time));
                    break;
                case "SUV":
                    trips.add(new SUVCab(km, time));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Cab c : trips) {
            double fare = c.calculateFare();
            if (fare == -1) {
                System.out.println(c.getType() + ": night service not available");
            } else {
                System.out.println(c.getType() + ": " + df.format(fare));
                total += fare;
            }
        }

        System.out.println("Total: " + df.format(total));
    }
}

