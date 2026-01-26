public class FirstNonRepeating {
    public static void main(String[] args) {
        String text = "swiss";
        int[] freq = new int[256];
        for(int i = 0; i < text.length(); i++) freq[text.charAt(i)]++;
        for(int i = 0; i < text.length(); i++) {
            if(freq[text.charAt(i)] == 1) {
                System.out.println("First non-repeating: " + text.charAt(i));
                return;
            }
        }
    }
}