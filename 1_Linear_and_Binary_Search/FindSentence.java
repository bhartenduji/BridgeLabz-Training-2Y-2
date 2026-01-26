public class FindSentence {
    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java programming", "Linear search example"};
        String target = "Java";
        String result = "Not Found";
        for (String sentence : sentences) {
            if (sentence.contains(target)) {
                result = sentence;
                break;
            }
        }
        System.out.println("Result: " + result);
    }
}