public class ManualUpper {
    public static void main(String[] args) {
        String text = "java";
        String res = "";
        for(char c : text.toCharArray()) {
            if(c >= 'a' && c <= 'z') res += (char)(c - 32);
            else res += c;
        }
        System.out.println(res);
    }
}