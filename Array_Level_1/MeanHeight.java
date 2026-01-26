public class MeanHeight {
    public static void main(String[] args) {
        double[] heights = {170, 172, 175, 168, 180, 178, 169, 174, 173, 171, 176};
        double sum = 0;
        for(double h : heights) sum += h;
        System.out.println("Mean: " + (sum / 11));
    }
}