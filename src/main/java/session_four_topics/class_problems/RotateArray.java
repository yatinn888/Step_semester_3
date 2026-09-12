package session_four_topics.class_problems;

import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        k = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rotated = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(rotated));
    }
}