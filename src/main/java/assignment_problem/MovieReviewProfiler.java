public class MovieReviewProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.isEmpty()) {
            System.out.println("Error: Review is empty.");
            return;
        }

        // Split review into words (by spaces)
        String[] words = review.split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount +
                " | Medium: " + mediumCount +
                " | Long: " + longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}
