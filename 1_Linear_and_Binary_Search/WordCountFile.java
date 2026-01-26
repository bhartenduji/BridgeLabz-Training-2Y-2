import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class WordCountFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter word to search: ");
        String targetWord = scanner.nextLine();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) count++;
                }
            }
            System.out.println("Occurrences of '" + targetWord + "': " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}