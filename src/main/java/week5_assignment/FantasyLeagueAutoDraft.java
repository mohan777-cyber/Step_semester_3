package week5_assignment;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    // Overloaded draftable checks
    static boolean isDraftable(int matchesPlayed) {
        // Established players qualify if they have played at least 10 matches
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        // Newer players qualify if they have played at least 5 matches and are not injured
        return matchesPlayed >= 5 && !injured;
    }

    // Comparable implementation: sort by batting average descending
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Draft and rank method
    static String draftAndRank(Player[] players) {
        // Filter draftable players
        Player[] draftable = Arrays.stream(players)
                .filter(p -> isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured))
                .toArray(Player[]::new);

        // Sort by batting average descending
        Arrays.sort(draftable);

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}

public class FantasyLeagueAutoDraft {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(Player.draftAndRank(players));
        // Output: 1. Rahul | 2. Virat | 3. Dev
    }
}
