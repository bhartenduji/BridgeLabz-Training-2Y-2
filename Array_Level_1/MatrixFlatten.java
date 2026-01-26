public class MatrixFlatten {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int[] flat = new int[4];
        int k = 0;
        for(int[] row : mat) {
            for(int val : row) flat[k++] = val;
        }
        for(int x : flat) System.out.print(x + " ");
    }
}