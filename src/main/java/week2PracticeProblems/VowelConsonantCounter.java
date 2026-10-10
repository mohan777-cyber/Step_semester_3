public class VowelConsonantCounter {

    // Method to count vowels and consonants
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        text = text.toLowerCase(); // case-insensitive

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') continue; // ignore spaces

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (c >= 'a' && c <= 'z') { // only letters
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String title = "Java Programming"; // Example input
        System.out.println("Input: \"" + title + "\"");
        countVowelsAndConsonants(title);
    }
}
