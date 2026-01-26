public class StudentGrades {
    public static void main(String[] args) {
        int students = 5;
        double[][] scores = new double[students][3]; 
        System.out.println("Total\tAvg\tGrade");
        for(int i=0; i<students; i++) {
            double total = 0;
            for(int j=0; j<3; j++) {
                scores[i][j] = Math.random() * 100;
                total += scores[i][j];
            }
            double avg = total / 3;
            String grade = (avg >= 80) ? "A" : (avg >= 70) ? "B" : (avg >= 60) ? "C" : (avg >= 50) ? "D" : (avg >= 40) ? "E" : "R";
            System.out.printf("%.1f\t%.1f\t%s\n", total, avg, grade);
        }
    }
}