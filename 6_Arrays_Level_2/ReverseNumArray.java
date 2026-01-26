public class ReverseNumArray {
    public static void main(String[] args) {
        int num = 12345;
        String s = String.valueOf(num);
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++) arr[i] = s.charAt(i) - '0';
        System.out.print("Reversed: ");
        for(int i=arr.length-1; i>=0; i--) System.out.print(arr[i]);
    }
}