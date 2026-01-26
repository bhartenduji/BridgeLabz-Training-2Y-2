public class VowelConsonantCount {
    public static void main(String[] args) {
        String text = "Automation";
        int v = 0, c = 0;
        text = text.toLowerCase();
        for(int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            if("aeiou".indexOf(ch) != -1) v++;
            else if(ch >= 'a' && ch <= 'z') c++;
        }
        System.out.println("Vowels: " + v + ", Consonants: " + c);
    }
}