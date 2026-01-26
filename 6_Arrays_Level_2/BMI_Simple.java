public class BMI_Simple {
    public static void main(String[] args) {
        double w = 70, h = 1.75;
        double bmi = w / (h*h);
        String status = (bmi <= 18.4) ? "Underweight" : (bmi <= 24.9) ? "Normal" : "Overweight";
        System.out.println("BMI: " + bmi + " Status: " + status);
    }
}