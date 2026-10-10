package week10assignment;

import java.util.Arrays;

public class RotateRoster {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;

        // Reduce k to avoid unnecessary full rotations
        k = k % n;

        String[] rotated = new String[n];

        // Place each name in its new position
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        System.out.println(Arrays.toString(rotateRoster(names1, k1)));
        // Expected Output: [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        System.out.println(Arrays.toString(rotateRoster(names2, k2)));
        // Expected Output: [D, E, A, B, C]
    }
}

