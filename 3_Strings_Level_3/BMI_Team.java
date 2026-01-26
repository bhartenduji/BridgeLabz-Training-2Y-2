import java.util.Scanner;
public class BMI_Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][2];
        for(int i = 0; i < 10; i++) {
            System.out.print("Person " + (i+1) + " Weight(kg) and Height(cm): ");
            data[i][0] = scanner.nextDouble();
            data[i][1] = scanner.nextDouble();
        }
        System.out.println("Height\tWeight\tBMI\tStatus");
        for(int i = 0; i < 10; i++) {
            double hM = data[i][1] / 100.0;
            double bmi = data[i][0] / (hM * hM);
            String status = (bmi <= 18.4) ? "Underweight" : (bmi <= 24.9) ? "Normal" : (bmi <= 39.9) ? "Overweight" : "Obese";
            System.out.printf("%.0f\t%.0f\t%.2f\t%s\n", data[i][1], data[i][0], bmi, status);
        }
    }
}