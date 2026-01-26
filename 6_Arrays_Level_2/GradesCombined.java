public class GradesCombined {
    public static void main(String[] args) {
        double[][] marks = {{85, 90, 80}, {60, 55, 65}}; 
        for(int i=0; i<marks.length; i++) {
            double sum = 0;
            for(double m : marks[i]) sum += m;
            double pct = sum/3;
            String grade = (pct >= 80) ? "A" : "B";
            System.out.println("Student " + i + ": " + grade);
        }
    }
}