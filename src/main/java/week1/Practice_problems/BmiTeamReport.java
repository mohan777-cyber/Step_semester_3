import java.util.*;

public class BmiTeamReport {

    // Method to classify BMI status
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    // Method to print the wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-10s %-12s\n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-12s\n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int teamSize = 10;

        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Generate random demo values
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + rand.nextDouble() * 0.5; // between 1.50m and 2.00m
            weights[i] = 45 + rand.nextDouble() * 55;    // between 45kg and 100kg
        }

        // Print the report
        printWellnessReport(heights, weights);
    }
}
