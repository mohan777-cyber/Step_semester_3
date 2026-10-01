import java.util.*;

abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 1.01; }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) { super(amount); }
    double calculateFinalAmount() { return amount; }
}

public class feecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double total = 0;

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Payment p = null;

            switch (type) {
                case "CARD": p = new CardPayment(amt); break;
                case "WALLET": p = new WalletPayment(amt); break;
                case "BANKTRANSFER": p = new BankTransfer(amt); break;
            }

            double finalAmt = p.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

