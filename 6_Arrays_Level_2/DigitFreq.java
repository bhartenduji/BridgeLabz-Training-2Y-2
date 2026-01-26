public class DigitFreq {
    public static void main(String[] args) {
        long num = 1122334;
        int[] freq = new int[10];
        while(num > 0) {
            freq[(int)(num % 10)]++;
            num /= 10;
        }
        for(int i=0; i<10; i++) {
            if(freq[i] > 0) System.out.println("Digit " + i + ": " + freq[i]);
        }
    }
}