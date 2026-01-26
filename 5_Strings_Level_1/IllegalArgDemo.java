public class IllegalArgDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(-100);
        } catch (IllegalArgumentException | InterruptedException e) {
            System.out.println("Caught Illegal Argument");
        }
    }
}