package week7_assignment;

class PasswordChecker {
    private final String password; // stored privately, never exposed

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Method to return strength rating
    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            // Optional extra check: contains a digit
            if (password.matches(".*\\d.*")) {
                return "Strong (with digit)";
            }
            return "Strong";
        }
    }
}

public class PasswordCheckerDemo {
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println(pc3.getStrength()); // Strong

        PasswordChecker pc4 = new PasswordChecker("abc123xyz789");
        System.out.println(pc4.getStrength()); // Strong (with digit)
    }
}
