public class WordLengths {
    public static void main(String[] args) {
        String text = "Hello Java";
        String[] words = text.split(" ");
        String[][] result = new String[words.length][2];
        for(int i=0; i<words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
            System.out.println(result[i][0] + " - " + result[i][1]);
        }
    }
}