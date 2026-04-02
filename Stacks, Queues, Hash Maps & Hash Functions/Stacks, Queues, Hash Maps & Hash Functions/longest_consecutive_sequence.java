package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.HashSet;

public class longest_consecutive_sequence {
    public static int findLongestConseqSubseq(int[] arr) {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;
        for (int j : arr) S.add(j);

        for (int i = 0; i < arr.length; ++i) {
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j)) j++;
                if (ans < j - arr[i]) ans = j - arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length is " + findLongestConseqSubseq(arr));
    }
}