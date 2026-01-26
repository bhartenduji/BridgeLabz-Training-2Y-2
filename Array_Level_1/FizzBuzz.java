public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        String[] res = new String[n+1];
        for(int i=1; i<=n; i++) {
            if(i%3==0 && i%5==0) res[i] = "FizzBuzz";
            else if(i%3==0) res[i] = "Fizz";
            else if(i%5==0) res[i] = "Buzz";
            else res[i] = String.valueOf(i);
            System.out.println("Position " + i + " = " + res[i]);
        }
    }
}