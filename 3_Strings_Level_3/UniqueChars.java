public class UniqueChars {
    public static void main(String[] args) {
        String text = "hello world";
        char[] unique = new char[text.length()];
        int k = 0;
        for(int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for(int j = 0; j < i; j++) {
                if(text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) unique[k++] = current;
        }
        System.out.print("Unique: ");
        for(int i = 0; i < k; i++) System.out.print(unique[i] + " ");
    }
}