import java.util.Scanner;
public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter month and year: ");
        int m = s.nextInt();
        int y = s.nextInt();
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) days[2] = 29;
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < d0; i++) System.out.print("    ");
        for (int i = 1; i <= days[m]; i++) {
            System.out.printf("%3d ", i);
            if ((i + d0) % 7 == 0) System.out.println();
        }
    }
}