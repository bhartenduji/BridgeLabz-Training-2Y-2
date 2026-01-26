public class ManualTrim {
    public static void main(String[] args) {
        String text = "  Hello  ";
        int start = 0, end = text.length() - 1;
        while(start <= end && text.charAt(start) == ' ') start++;
        while(end >= start && text.charAt(end) == ' ') end--;
        String trimmed = "";
        for(int i=start; i<=end; i++) trimmed += text.charAt(i);
        System.out.println("Original: '" + text + "'");
        System.out.println("Trimmed: '" + trimmed + "'");
    }
}