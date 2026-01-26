public class InsertionSort {
    public static void main(String[] args) {
        int[] ids = {105, 102, 108, 101, 103};
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
        for(int id : ids) System.out.print(id + " ");
    }
}