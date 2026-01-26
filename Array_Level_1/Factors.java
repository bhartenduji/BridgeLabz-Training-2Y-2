public class Factors {
    public static void main(String[] args) {
        int num = 12;
        int[] factors = new int[num];
        int idx = 0;
        for(int i=1; i<=num; i++) {
            if(num % i == 0) factors[idx++] = i;
        }
        System.out.print("Factors: ");
        for(int i=0; i<idx; i++) System.out.print(factors[i] + " ");
    }
}