import java.util.Scanner;
public class BonusCalc {
    public static void main(String[] args) {
        double[] salary = {5000, 6000, 7000};
        double[] years = {6, 3, 7};
        double totalBonus = 0;
        for(int i=0; i<salary.length; i++) {
            double bonus = (years[i] > 5) ? salary[i]*0.05 : salary[i]*0.02;
            totalBonus += bonus;
            System.out.println("Emp " + i + " New Salary: " + (salary[i] + bonus));
        }
        System.out.println("Total Bonus: " + totalBonus);
    }
}