package week5_assignment;

public class MatchDayGridAnalyzer {

    // Helper method: computes average runs for one match (row)
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    // Classify each match as Power Surge or Normal
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]); // reuse helper
            if (avg >= threshold) {
                result.append("Match ").append(i).append(": Power Surge");
            } else {
                result.append("Match ").append(i).append(": Normal");
            }

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        int threshold = 8;

        System.out.println(classifyMatches(runsPerOver, threshold));
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
