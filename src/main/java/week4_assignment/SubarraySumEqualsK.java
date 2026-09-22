package week4_assignment;

import java.util.*;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        // Map to store frequency of prefix sums
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: empty prefix

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if there exists a prefix sum such that currentSum - prefixSum = k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2)); // Output: 3
    }
}
