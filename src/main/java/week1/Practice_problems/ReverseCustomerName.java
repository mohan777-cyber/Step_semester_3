public class ReverseCustomerName {

    // Method to reverse the customer name
    public static String reverseCustomerName(String customerName) {
        StringBuilder reversed = new StringBuilder();
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed.append(customerName.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil"; // Example input
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
