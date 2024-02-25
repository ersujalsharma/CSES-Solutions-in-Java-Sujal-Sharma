import java.util.*;
 
public class Digit_Queries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        long[] pref = new long[19];
        pref[0] = 0;
        for (int i = 1; i < 19; i++) {
            pref[i] = (i * (9 * (long)Math.pow(10, i - 1)));
        }
        while(q-->0){
            long k = scanner.nextLong();
            long len = 1, start = 1, count = 9;
 
        // Find the length of the block of numbers containing the digit
            while (k > len * count) {
                k -= len * count;
                len++;
                start *= 10;
                count *= 10;
            }
 
            // Find the number containing the digit
            long num = start + (k - 1) / len;
 
            // Find the position of the digit within the number
            int digitPos = (int) ((k - 1) % len);
 
            // Extract and return the digit
            String numStr = Long.toString(num);
            System.out.println( numStr.charAt(digitPos) - '0');
        }
    }
}
