public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        System.out.println("First: " + first + ", Last: " + last);
    }
    static int findBound(int[] arr, int target, boolean isFirst) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}