package week8_assignment;

import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;
    Plan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    abstract LocalDate getRenewalDate();
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate start = LocalDate.parse(dateStr);
            Plan p = null;

            switch (type) {
                case "BASIC": p = new BasicPlan(name, start); break;
                case "STANDARD": p = new StandardPlan(name, start); break;
                case "PREMIUM": p = new PremiumPlan(name, start); break;
            }

            LocalDate renewal = p.getRenewalDate();
            System.out.printf("%s: %s%n", p.name, renewal);
        }
    }
}

