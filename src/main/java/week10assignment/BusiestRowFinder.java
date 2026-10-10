package week10assignment;

public class BusiestRowFinder {

    public static void busiestRow(int[][] grid) {
        int bestRowIndex = 0;
        int bestTotal = 0;

        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
            }

            // Update only if strictly larger
            if (rowSum > bestTotal) {
                bestTotal = rowSum;
                bestRowIndex = i;
            }
        }

        System.out.println("Row " + bestRowIndex + ", Total " + bestTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        busiestRow(grid); // Expected Output: Row 1, Total 7
    }
}
