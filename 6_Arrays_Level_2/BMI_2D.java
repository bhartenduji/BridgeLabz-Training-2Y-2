public class BMI_2D {
    public static void main(String[] args) {
        double[][] data = {{70, 1.75}, {90, 1.80}};
        for(double[] person : data) {
            double bmi = person[0] / (person[1]*person[1]);
            System.out.printf("BMI: %.2f\n", bmi);
        }
    }
}