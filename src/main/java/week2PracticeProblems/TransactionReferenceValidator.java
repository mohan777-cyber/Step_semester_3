public class TransactionReferenceValidator {

    // Normalize raw reference: trim spaces and uppercase first 3 chars
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed; // not enough chars
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    // Validate and format the normalized reference
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length (must be 14 characters)";
        }

        // Check first 3 are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);   // ddMMyy
        String seq = reference.substring(9);       // 5 digits

        // Format date as dd/MM/yy
        String formattedDate = date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        // Build formatted display
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
                .append("DATE: ").append(formattedDate)
                .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String raw2 = "12F03022600042";

        String ref1 = normalizeReference(raw1);
        String ref2 = normalizeReference(raw2);

        System.out.println(raw1 + " → " + validateAndFormat(ref1));
        System.out.println(raw2 + " → " + validateAndFormat(ref2));
    }
}
