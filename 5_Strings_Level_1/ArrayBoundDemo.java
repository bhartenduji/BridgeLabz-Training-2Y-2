public class ArrayBoundDemo {
    public static void main(String[] args) {
        int[] arr = {1};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Array Index Out Of Bounds");
        }
    }
}