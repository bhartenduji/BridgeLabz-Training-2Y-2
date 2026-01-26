public class NumAnalysis {
    public static void main(String[] args) {
        int[] nums = {10, -5, 0, 3, 8};
        for(int n : nums) {
            if(n > 0) System.out.println(n + ": Positive, " + (n%2==0 ? "Even" : "Odd"));
            else if(n < 0) System.out.println(n + ": Negative");
            else System.out.println("Zero");
        }
        if(nums[0] == nums[4]) System.out.println("First == Last");
        else System.out.println("First != Last");
    }
}