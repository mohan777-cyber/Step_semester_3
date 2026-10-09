package week9.Assignment_Problems;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0; // single place for fee

    public Ticket(int count) {
        this.count = count;
    }

    // Subclasses define base price per ticket
    public abstract double pricePerTicket();

    // Common method to calculate total with fee
    public double totalAmount() {
        return (pricePerTicket() + CONVENIENCE_FEE) * count;
    }

    public abstract String getSeatType();
}

// Regular seat
class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double pricePerTicket() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

// Premium seat
class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double pricePerTicket() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

// Recliner seat
class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double pricePerTicket() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String seatType = parts[0];
            int count = Integer.parseInt(parts[1]);

            switch (seatType) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (Ticket t : tickets) {
            double amount = t.totalAmount();
            System.out.println(t.getSeatType() + ": " + df.format(amount));
            total += amount;
        }

        System.out.println("Total: " + df.format(total));
    }
}

