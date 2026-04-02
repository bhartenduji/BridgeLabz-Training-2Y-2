package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.HashSet;

public class pair_given_sum {
    public static void findPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            int complement = target - j;
            if (set.contains(complement)) {
                System.out.println("Pair found: " + j + ", " + complement);
                return;
            }
            set.add(j);
        }
        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        findPair(arr, target);
    }
}