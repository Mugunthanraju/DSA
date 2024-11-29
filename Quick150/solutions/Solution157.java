package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution157 {
    // TC : O( N LogN )
    // SC : O( N )

    public static int[] arrayRankTransform(int[] arr) {
        // Make a copy of input array
        int[] arrayCopied = Arrays.copyOf(arr, arr.length);

        // Sort the duplicate the array
        Arrays.sort(arrayCopied);

        // Create a map for storing the rank
        Map<Integer, Integer> rank = new HashMap<>();

        // Store the rank as rank.size() + 1 for each number
        for (int i : arrayCopied)
            rank.putIfAbsent(i, rank.size() + 1);

        // Now, save the rank in duplicate array based on input
        for (int i = 0; i < arr.length; i++) {
            arrayCopied[i] = rank.get(arr[i]);
        }

        return arrayCopied;
    }

    public static void main(String[] args) {
        int[] arr1 = { 40, 10, 20, 30 };
        // [4, 1, 2, 3]
        System.out.println(Arrays.toString(arrayRankTransform(arr1)));
        int[] arr2 = { 100, 100, 100 };
        // [1, 1, 1]
        System.out.println(Arrays.toString(arrayRankTransform(arr2)));
        int[] arr3 = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };
        // [5, 3, 4, 2, 8, 6, 7, 1, 3]
        System.out.println(Arrays.toString(arrayRankTransform(arr3)));
    }
}