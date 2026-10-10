public class MaskedPhoneNumber {

    // Method to mask phone number
    public static String maskPhoneNumber(String phone) {
        // Validation: must be exactly 10 digits
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked version: "XXXXXX-Last4"
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6)); // last 4 digits

        return sb.toString();
    }

    public static void main(String[] args) {
        // Example inputs
        System.out.println("9876543210 → " + maskPhoneNumber("9876543210"));
        System.out.println("98765 → " + maskPhoneNumber("98765"));
        System.out.println("123456789a → " + maskPhoneNumber("123456789a"));
    }
}
