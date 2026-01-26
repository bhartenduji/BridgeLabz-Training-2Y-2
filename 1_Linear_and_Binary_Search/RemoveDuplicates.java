import java.util.Scanner;
import java.util.HashSet;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (!seen.contains(current)) {
                seen.add(current);
                sb.append(current);
            }
        }
        System.out.println("String without duplicates: " + sb.toString());
    }
}