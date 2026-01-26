import java.util.Scanner;
public class ReverseStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        System.out.println("Reversed string: " + sb.toString());
    }
}