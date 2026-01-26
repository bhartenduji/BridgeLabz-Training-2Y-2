import java.util.Scanner;
public class ManualLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int count = 0;
        try {
            while(true) {
                text.charAt(count);
                count++;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Length: " + count);
        }
    }
}