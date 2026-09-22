package week4_assignment;

public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search loop
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare mid with rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }

        // When loop ends, left == right → minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1)); // Output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2)); // Output: 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3)); // Output: 11
    }
}
