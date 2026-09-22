package week6_assignment;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative salary not allowed. Starting at 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0; // start with no bonus
    }

    // Credit bonus (must be positive)
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus amount must be positive.");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax by percentage (must be between 0 and 100)
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage. Must be between 0 and 100.");
        } else {
            double deduction = basicSalary * (percent / 100.0);
            basicSalary -= deduction;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Read-only access to net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollSalaryManagement {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);   // valid bonus
        account.deductTax(10);       // valid tax deduction

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}

