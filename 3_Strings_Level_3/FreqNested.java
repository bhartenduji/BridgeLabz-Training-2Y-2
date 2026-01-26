public class FreqNested {
    public static void main(String[] args) {
        String str = "programming";
        char[] chars = str.toCharArray();
        int[] freq = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for(int j = i + 1; j < str.length(); j++) {
                if(chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        for(int i = 0; i < freq.length; i++) {
            if(chars[i] != '0' && chars[i] != ' ')
                System.out.println(chars[i] + ": " + freq[i]);
        }
    }
}