public class StringCompare {
    public static void main(String[] args) {
        String s1 = "abc", s2 = "abc";
        boolean match = true;
        if(s1.length() == s2.length()) {
            for(int i=0; i<s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) match = false;
            }
        } else match = false;
        System.out.println("Manual: " + match);
        System.out.println("Built-in: " + s1.equals(s2));
    }
}