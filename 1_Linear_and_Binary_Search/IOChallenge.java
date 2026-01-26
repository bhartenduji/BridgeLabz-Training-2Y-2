import java.io.*;
public class IOChallenge {
    public static void main(String[] args) throws IOException {
        long start, end;
        int iterations = 1000000;
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start));
        start = System.nanoTime();
        StringBuffer sbuff = new StringBuffer();
        for (int i = 0; i < iterations; i++) sbuff.append("a");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start));
        File file = new File("largefile.txt"); 
        if (file.exists()) {
            start = System.nanoTime();
            try (FileReader fr = new FileReader(file)) {
                while (fr.read() != -1);
            }
            end = System.nanoTime();
            System.out.println("FileReader time: " + (end - start));
            start = System.nanoTime();
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
                while (isr.read() != -1);
            }
            end = System.nanoTime();
            System.out.println("InputStreamReader time: " + (end - start));
        }
    }
}