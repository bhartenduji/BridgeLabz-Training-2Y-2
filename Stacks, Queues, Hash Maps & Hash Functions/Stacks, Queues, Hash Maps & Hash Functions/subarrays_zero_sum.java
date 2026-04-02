package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.*;

public class subarrays_zero_sum {
    public static void findSubArrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                System.out.println("Subarray from 0 to " + i);
            }
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int idx : list) {
                    System.out.println("Subarray from " + (idx + 1) + " to " + i);
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        findSubArrays(arr);
    }
}