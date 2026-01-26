public class CountingSort {
    public static void main(String[] args) {
        int[] ages = {18, 15, 12, 18, 15, 10, 12};
        int max = 18;
        int[] count = new int[max + 1];
        int[] output = new int[ages.length];
        for (int age : ages) count[age]++;
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }
        for(int a : output) System.out.print(a + " ");
    }
}