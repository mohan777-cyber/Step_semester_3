package week10assignment;

public class AttendanceSummary {

    public static void attendanceSummary(int[] days) {
        int presentCount = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // reset streak on absence
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1}; // Sample 1
        int[] days2 = {0, 0, 0};                // Sample 2

        attendanceSummary(days1); // Expected: Present: 6, Longest streak: 3
        attendanceSummary(days2); // Expected: Present: 0, Longest streak: 0
    }
}

