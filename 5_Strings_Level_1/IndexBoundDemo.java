public class IndexBoundDemo {
    public static void main(String[] args) {
        String text = "Hi";
        try {
            System.out.println(text.charAt(5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught OutOfBounds");
        }
    }
}