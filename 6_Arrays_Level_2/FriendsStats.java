public class FriendsStats {
    public static void main(String[] args) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = {25, 22, 28};
        double[] heights = {170, 175, 165};
        int minAgeIdx = 0, maxHeightIdx = 0;
        for(int i=1; i<3; i++) {
            if(ages[i] < ages[minAgeIdx]) minAgeIdx = i;
            if(heights[i] > heights[maxHeightIdx]) maxHeightIdx = i;
        }
        System.out.println("Youngest: " + names[minAgeIdx]);
        System.out.println("Tallest: " + names[maxHeightIdx]);
    }
}