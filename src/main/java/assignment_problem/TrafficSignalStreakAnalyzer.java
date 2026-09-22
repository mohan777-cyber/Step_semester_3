public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Error: Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                // Reset streak
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            // Update longest streak if needed
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {
        String log1 = "RRGGGYRR";
        String log2 = "RRRRYYGG";

        System.out.println("Test 1:");
        findLongestStreak(log1);

        System.out.println("\nTest 2:");
        findLongestStreak(log2);
    }
}

