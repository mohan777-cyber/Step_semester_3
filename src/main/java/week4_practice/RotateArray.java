import java.util.Arrays;

public class RotateArray {

    // Method to rotate array to the right by k positions
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        // Reduce k to avoid unnecessary rotations
        k = k % n;

        int[] newArray = new int[n];

        // Place each element in its new position
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] rotated1 = rotateArray(nums1, k1);
        System.out.println("Rotated Array: " + Arrays.toString(rotated1));
        // Output: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] rotated2 = rotateArray(nums2, k2);
        System.out.println("Rotated Array: " + Arrays.toString(rotated2));
        // Output: [2, 1]
    }
}
