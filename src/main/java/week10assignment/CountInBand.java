package week10assignment;

import java.util.Arrays;

public class CountInBand {

    public static int countInBand(int[] scores, int low, int high) {
        int left = lowerBound(scores, low);   // first index with score >= low
        int right = upperBound(scores, high); // first index with score > high
        return right - left;                  // number of elements in [low, high]
    }

    // Binary search for first index with value >= target
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Binary search for first index with value > target
    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); // Expected: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected: 0
    }
}
