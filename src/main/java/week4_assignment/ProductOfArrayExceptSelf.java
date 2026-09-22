package week4_assignment;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Forward pass – product of all elements to the left
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Step 2: Backward pass – multiply by product of all elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // [0, 0, 9, 0, 0]
    }
}
