public class FirstNegative {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, -3, 8, -9};
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                index = i;
                break;
            }
        }
        System.out.println("Index of first negative number: " + index);
    }
}