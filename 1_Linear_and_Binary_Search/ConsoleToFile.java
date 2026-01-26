import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
public class ConsoleToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("output.txt")) {
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + "\n");
            }
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}