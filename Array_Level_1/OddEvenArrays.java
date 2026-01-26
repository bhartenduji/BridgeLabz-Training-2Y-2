public class OddEvenArrays {
    public static void main(String[] args) {
        int n = 10;
        int[] odd = new int[n/2 + 1];
        int[] even = new int[n/2 + 1];
        int o=0, e=0;
        for(int i=1; i<=n; i++) {
            if(i%2 != 0) odd[o++] = i;
            else even[e++] = i;
        }
        System.out.print("Odds: ");
        for(int i=0; i<o; i++) System.out.print(odd[i] + " ");
    }
}