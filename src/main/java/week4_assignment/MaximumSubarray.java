package week4_assignment;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        // Initialize with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array
        for (int i = 1; i < nums.length; i++) {
            // Decide: extend current subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Output: 6

        int[] nums2 = {-3, -1, -2};
        System.out.println(maxSubArray(nums2)); // Output: -1
    }
}
