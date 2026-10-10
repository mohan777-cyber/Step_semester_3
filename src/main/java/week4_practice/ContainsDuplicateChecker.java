public class ContainsDuplicateChecker {

    // Method to check if array contains any duplicate
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // duplicate found, return immediately
                }
            }
        }
        return false; // no duplicates found
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("nums1 contains duplicate? " + containsDuplicate(nums1)); // true
        System.out.println("nums2 contains duplicate? " + containsDuplicate(nums2)); // false
    }
}
