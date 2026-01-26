import java.util.Arrays;
public class SearchChallenge {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findMissingPositive(nums));
        int[] sortedNums = {1, 3, 4, 7, 9};
        System.out.println("Target index: " + binarySearch(sortedNums, 3));
    }
    static int findMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }
        return n + 1;
    }
    static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}