public class CharTypeTable {
    public static void main(String[] args) {
        String text = "Java";
        System.out.println("Char\tType");
        for(char ch : text.toLowerCase().toCharArray()) {
            String type = "Not Letter";
            if(ch >= 'a' && ch <= 'z') 
                type = "aeiou".indexOf(ch) != -1 ? "Vowel" : "Consonant";
            System.out.println(ch + "\t" + type);
        }
    }
}