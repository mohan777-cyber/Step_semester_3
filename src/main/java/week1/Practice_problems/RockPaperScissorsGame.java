import java.util.*;

public class RockPaperScissorsGame {

    // Method to decide the result of one round
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        switch (playerMove) {
            case "Rock":
                return (computerMove.equals("Scissors")) ? "Player Wins" : "Computer Wins";
            case "Paper":
                return (computerMove.equals("Rock")) ? "Player Wins" : "Computer Wins";
            case "Scissors":
                return (computerMove.equals("Paper")) ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5; // suggested number of rounds
        int wins = 0, losses = 0, draws = 0;

        // Store round details
        String[][] summary = new String[rounds][4];

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine().trim();

            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            // Record round details
            summary[i][0] = "Round " + (i + 1);
            summary[i][1] = playerMove;
            summary[i][2] = computerMove;
            summary[i][3] = result;

            // Update stats
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else if (result.equals("Draw")) draws++;

            System.out.println(summary[i][0] + " — Player: " + playerMove + ", Computer: " + computerMove + " → " + result);
        }

        // Print final summary
        System.out.println("\nFinal Summary:");
        System.out.printf("%-8s %-12s %-15s %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8s %-12s %-15s %-15s\n", summary[i][0], summary[i][1], summary[i][2], summary[i][3]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");

        sc.close();
    }
}
