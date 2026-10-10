import java.util.*;

public class FirstUniqueCharFinder {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {
        // Frequency map
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Scan left to right for the first unique character
        for (char c : text.toCharArray()) {
            if (freqMap.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // special marker if none found
    }

    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc", "programming", "unique"};

        for (String input : testInputs) {
            char result = findFirstNonRepeatingChar(input);
            if (result == '\0') {
                System.out.println("Input: \"" + input + "\" → No Non-Repeating Character Found");
            } else {
                System.out.println("Input: \"" + input + "\" → First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}
