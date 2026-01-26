import java.util.Scanner;
public class StoreValues {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double[] vals = new double[10];
        int i = 0;
        double sum = 0;
        while(i < 10) {
            double in = s.nextDouble();
            if(in <= 0) break;
            vals[i++] = in;
            sum += in;
        }
        System.out.println("Sum: " + sum);
    }
}