public class VotingArray {
    public static void main(String[] args) {
        int[] ages = {12, 18, 25, 10};
        for(int age : ages) {
            if(age >= 18) System.out.println(age + ": Can vote");
            else System.out.println(age + ": Cannot vote");
        }
    }
}