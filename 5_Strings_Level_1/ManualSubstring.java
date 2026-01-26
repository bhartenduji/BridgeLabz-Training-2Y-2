public class ManualSubstring {
    public static void main(String[] args) {
        String str = "BridgeLabz";
        int start = 2, end = 6;
        String sub = "";
        for(int i=start; i<end; i++) sub += str.charAt(i);
        System.out.println("Manual: " + sub);
        System.out.println("Built-in: " + str.substring(start, end));
    }
}