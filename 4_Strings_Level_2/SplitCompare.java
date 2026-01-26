import java.util.ArrayList;
public class SplitCompare {
    public static void main(String[] args) {
        String text = "Java is fun";
        String[] builtIn = text.split(" ");
        ArrayList<String> manualList = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != ' ') temp += text.charAt(i);
            else { manualList.add(temp); temp = ""; }
        }
        manualList.add(temp);
        System.out.println("Match: " + (builtIn.length == manualList.size()));
    }
}