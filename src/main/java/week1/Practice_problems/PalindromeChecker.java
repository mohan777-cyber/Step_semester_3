public class PalindromeChecker {

    // Iterative approach: compare characters from both ends
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Recursive approach: shrink substring each call
    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) return true; // base case
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    // Array reversal approach: reverse and compare
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }

    public static void main(String[] args) {
        String[] testInputs = {"madam", "hello", "racecar", "level"};

        for (String input : testInputs) {
            boolean iterative = isPalindromeIterative(input);
            boolean recursive = isPalindromeRecursive(input);
            boolean arrayRev = isPalindromeArrayReversal(input);

            System.out.println("Input: " + input);
            System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome"));
            System.out.println("Recursive: " + (recursive ? "Palindrome" : "Not Palindrome"));
            System.out.println("Array Reversal: " + (arrayRev ? "Palindrome" : "Not Palindrome"));
            System.out.println("-----------------------------------");
        }
    }
}
