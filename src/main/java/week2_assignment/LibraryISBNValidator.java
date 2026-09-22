package week2_assignment;

public class LibraryISBNValidator {

    // Normalize raw code: trim spaces and uppercase first 3 chars
    public static String normalizeCode(String raw) {
        if (raw == null) return "";

        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed; // not enough chars

        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return pubCode + rest;
    }

    // Validate and format the normalized code
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid Code: Wrong length (must be 13 characters)";
        }

        // Check first 3 are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid Code: Publisher code must be letters";
            }
        }

        // Check remaining 10 are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid Code: Year and catalog must be digits";
            }
        }

        // Extract parts
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        // Build formatted display
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year)
                .append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String raw = " pen2026004251 ";
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);
    }
}
