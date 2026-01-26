public class VoteCheck {
    public static void main(String[] args) {
        int[] ages = new int[10];
        for(int i=0; i<10; i++) ages[i] = (int)(Math.random() * 80);
        System.out.println("Age\tCan Vote?");
        for(int age : ages) {
            System.out.println(age + "\t" + (age >= 18));
        }
    }
}