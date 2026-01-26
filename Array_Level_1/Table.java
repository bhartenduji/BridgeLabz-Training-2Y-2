public class Table {
    public static void main(String[] args) {
        int num = 5;
        int[] table = new int[10];
        for(int i=0; i<10; i++) table[i] = num * (i+1);
        for(int x : table) System.out.print(x + " ");
    }
}