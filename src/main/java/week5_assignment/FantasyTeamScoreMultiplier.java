package week5_assignment;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    // Method that modifies the original array directly
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Double the captain's score
        playerScores[captainIndex] = playerScores[captainIndex] * 2;

        // Multiply vice-captain's score by 1.5
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);

        // Print modified array
        System.out.println(Arrays.toString(scores));
    }
}
