import java.util.Arrays;
public class CharArrayManual {
    public static void main(String[] args) {
        String str = "Test";
        char[] manual = new char[str.length()];
        for(int i=0; i<str.length(); i++) manual[i] = str.charAt(i);
        System.out.println("Equal: " + Arrays.equals(manual, str.toCharArray()));
    }
}