package week10practice;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        String word = "Programming"; // Sample input
        countVowelsAndConsonants(word);
    }

    public static void countVowelsAndConsonants(String word) {
        int vowels = 0, consonants = 0;
        word = word.toLowerCase(); // case-insensitive

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (c >= 'a' && c <= 'z') { // only alphabetic characters
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
