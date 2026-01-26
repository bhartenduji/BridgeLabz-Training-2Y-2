public class Palindrome {
    public static void main(String[] args) {
        String text = "madam";
        boolean isPal = true;
        for(int i = 0; i < text.length() / 2; i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPal = false;
                break;
            }
        }
        System.out.println("Is Palindrome: " + isPal);
    }
}