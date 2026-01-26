public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Peak element index: " + left);
    }
}