package week10practice;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        String word1 = "level";   // Sample input 1
        String word2 = "java";    // Sample input 2

        checkWord(word1);
        checkWord(word2);
    }

    public static void checkWord(String word) {
        // Reverse using StringBuilder
        String reversed = new StringBuilder(word).reverse().toString();

        // Check palindrome by comparing original and reversed
        boolean isPalindrome = word.equals(reversed);

        // Print results
        System.out.println(word + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
        System.out.println(reversed + " - " + (reversed.equals(new StringBuilder(reversed).reverse().toString())
                ? "palindrome" : "not a palindrome"));
        System.out.println("-----------------------------------");
    }
}

