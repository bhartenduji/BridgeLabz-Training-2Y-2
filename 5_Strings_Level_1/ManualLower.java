public class ManualLower {
    public static void main(String[] args) {
        String text = "JAVA";
        String res = "";
        for(char c : text.toCharArray()) {
            if(c >= 'A' && c <= 'Z') res += (char)(c + 32);
            else res += c;
        }
        System.out.println(res);
    }
}