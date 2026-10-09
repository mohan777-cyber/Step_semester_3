package week9.Practice_Practice;

import java.util.*;
import java.text.DecimalFormat;

// Abstract base class
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    // Force subclasses to implement fine calculation
    public abstract double calculateFine();
}

// Book
class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 2.0 * daysLate;
    }
}

// DVD
class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = 5.0 * daysLate;
        return Math.min(fine, 50.0); // capped at 50
    }
}

// Magazine
class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 1.0 * daysLate;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);

            switch (type) {
                case "BOOK":
                    items.add(new Book(title, daysLate));
                    break;
                case "DVD":
                    items.add(new DVD(title, daysLate));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title, daysLate));
                    break;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.println(item.title + ": " + df.format(fine));
            total += fine;
        }

        System.out.println("Total Fines: " + df.format(total));
    }
}
