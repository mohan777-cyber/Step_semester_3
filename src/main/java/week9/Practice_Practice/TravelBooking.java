package week9.Practice_Practice;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Booking {
    protected int distanceKm;
    protected static final double BOOKING_FEE = 50.0; // single place for fee

    public Booking(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    // Subclasses define base fare
    public abstract double baseFare();

    // Common method to add booking fee
    public double totalFare() {
        return baseFare() + BOOKING_FEE;
    }

    public abstract String getMode();
}

// Bus booking
class BusBooking extends Booking {
    public BusBooking(int distanceKm) {
        super(distanceKm);
    }

    @Override
    public double baseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

// Train booking
class TrainBooking extends Booking {
    public TrainBooking(int distanceKm) {
        super(distanceKm);
    }

    @Override
    public double baseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

// Flight booking
class FlightBooking extends Booking {
    public FlightBooking(int distanceKm) {
        super(distanceKm);
    }

    @Override
    public double baseFare() {
        return 2500 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String mode = parts[0];
            int distance = Integer.parseInt(parts[1]);

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distance));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Booking b : bookings) {
            double fare = b.totalFare();
            System.out.println(b.getMode() + ": " + df.format(fare));
            total += fare;
        }

        System.out.println("Total: " + df.format(total));
    }
}

