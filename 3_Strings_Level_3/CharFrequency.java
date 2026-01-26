public class CharFrequency {
    public static void main(String[] args) {
        String text = "banana";
        int[] freq = new int[256];
        for(int i = 0; i < text.length(); i++) freq[text.charAt(i)]++;
        System.out.println("Frequencies:");
        for(int i = 0; i < 256; i++) {
            if(freq[i] > 0) System.out.println((char)i + ": " + freq[i]);
        }
    }
}