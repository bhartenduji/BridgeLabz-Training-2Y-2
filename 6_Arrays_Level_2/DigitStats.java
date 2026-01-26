public class DigitStats {
    public static void main(String[] args) {
        long num = 94812;
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while(num > 0) {
            if(index == maxDigit) { 
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = (int)(num % 10);
            num /= 10;
        }
        int max = -1, second = -1;
        for(int i=0; i<index; i++) {
            if(digits[i] > max) { second = max; max = digits[i]; }
            else if(digits[i] > second) second = digits[i];
        }
        System.out.println("Largest: " + max + ", Second: " + second);
    }
}