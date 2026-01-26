public class ShortLongString {
    public static void main(String[] args) {
        String text = "I love programming";
        String[] words = text.split(" ");
        String min = words[0], max = words[0];
        for(String w : words) {
            if(w.length() < min.length()) min = w;
            if(w.length() > max.length()) max = w;
        }
        System.out.println("Shortest: " + min + ", Longest: " + max);
    }
}