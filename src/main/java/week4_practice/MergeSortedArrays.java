import java.util.Arrays;

public class MergeSortedArrays {

    // Method to merge two sorted arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];

        // Compare elements from both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("Merged Array: " + Arrays.toString(merged));

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] merged2 = mergeSortedArrays(arr3, arr4);
        System.out.println("Merged Array: " + Arrays.toString(merged2));
    }
}

