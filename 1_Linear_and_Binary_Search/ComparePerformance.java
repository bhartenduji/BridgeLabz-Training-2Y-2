public class ComparePerformance {
    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "test";
        long startTime = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) sBuffer.append(text);
        long bufferTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) sBuilder.append(text);
        long builderTime = System.nanoTime() - startTime;
        System.out.println("StringBuffer Time: " + bufferTime + " ns");
        System.out.println("StringBuilder Time: " + builderTime + " ns");
    }
}