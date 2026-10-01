 import java.util.*;

    abstract class Delivery {
        double weight, distance;
        Delivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
        abstract double fee();
    }

    class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) { super(w,d); }
        double fee() { return 5 + 0.5*weight + 0.1*distance; }
    }

    class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) { super(w,d); }
        double fee() { return 15 + 1.0*weight + 0.2*distance; }
    }

    class InternationalDelivery extends Delivery {
        double customsFee;
        InternationalDelivery(double w, double d, double c) { super(w,d); customsFee = c; }
        double fee() { return 25 + 2.0*weight + 0.5*distance + customsFee; }
    }

    public class deliveryfee {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            double total = 0;

            for (int i = 0; i < N; i++) {
                String type = sc.next();
                Delivery d = null;
                if (type.equals("STANDARD")) {
                    d = new StandardDelivery(sc.nextDouble(), sc.nextDouble());
                } else if (type.equals("EXPRESS")) {
                    d = new ExpressDelivery(sc.nextDouble(), sc.nextDouble());
                } else {
                    d = new InternationalDelivery(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                }
                double fee = d.fee();
                System.out.printf("%s: %.2f%n", type, fee);
                total += fee;
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }


