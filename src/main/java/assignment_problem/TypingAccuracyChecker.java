public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int matched = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // +1 for human-readable position
                }
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, original.length(), accuracy,
                    firstMismatchPos,
                    original.charAt(firstMismatchPos - 1),
                    typed.charAt(firstMismatchPos - 1));
        }
    }

    public static void main(String[] args) {
        String original1 = "hello world";
        String typed1 = "hello worlt";

        String original2 = "coding";
        String typed2 = "coding";

        System.out.println("Test 1:");
        checkTypingAccuracy(original1, typed1);

        System.out.println("\nTest 2:");
        checkTypingAccuracy(original2, typed2);
    }
}

