package week10practice;

public class InPlaceArrayReversal {

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44}; // Sample input

        reverseArray(tokens);

        // Print the reversed array
        System.out.print("[");
        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i]);
            if (i < tokens.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements at left and right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers inward
            left++;
            right--;
        }
    }
}

