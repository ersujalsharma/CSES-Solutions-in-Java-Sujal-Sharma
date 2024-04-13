import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static long[][][][] dp = new long[20][10][2][2];

    // Function to calculate the count of valid numbers using Digit DP
    static long mem(String s, int curr, int prev_digit, int leading_zero, int tight) {
        // Base case: entire number processed
        if (curr == 0) {
            return 1;
        }

        // Check if result for the current state is already computed
        if (dp[curr][prev_digit][leading_zero][tight] != -1)
            return dp[curr][prev_digit][leading_zero][tight];

        // Determine the limit for the current position based on tightness
      int limit;
        if (tight == 0) {
            limit = 9;
        } else {
            int sz = s.length();
            limit = s.charAt(sz - curr) - '0';
        }

        long countNumbers = 0;

        // Iterate through possible digits for the current position
        for (int curr_digit = 0; curr_digit <= limit; curr_digit++) {
            // Check validity based on constraints
            if (leading_zero == 0 && (curr_digit == prev_digit)) {
                continue;
            }

            // Update state parameters based on the current digit
            int new_leading_zero = (leading_zero == 1 && curr_digit == 0) ? 1 : 0;
            int new_tight = (curr_digit == limit && tight == 1) ? 1 : 0;

            // Recursively call the mem function for the next position
            countNumbers += mem(s, curr - 1, curr_digit, new_leading_zero, new_tight);
        }

        // Update the memoization table with the count of valid numbers for the current state
        dp[curr][prev_digit][leading_zero][tight] = countNumbers;

        return dp[curr][prev_digit][leading_zero][tight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong(), b = scanner.nextLong();

        long count1 = 0;
        // Initialize dp table with -1
        for (long[][][] arr3D : dp) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }

        // Calculate count of valid numbers from [0, a-1]
        String str1 = Long.toString(a - 1);
        if (a != 0)
            count1 = mem(str1, str1.length(), 0, 1, 1);

        // Calculate count of valid numbers from [0, b]
        for (long[][][] arr3D : dp) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }
        String str2 = Long.toString(b);
        long count2 = mem(str2, str2.length(), 0, 1, 1);

        // Output the difference between count of valid numbers from [0, b] and [0, a-1]
        System.out.println(count2 - count1);
    // public static void main(String[] args) {

    //     Scanner scanner = new Scanner(System.in);
    //     long first = scanner.nextLong();
    //     long second = scanner.nextLong();
    //     long sum = second-first+1;
    //     for(long val = first ;val <= second; val++){
    //         if(check(val)){
    //             sum--;
    //         }
    //     }
    //     System.out.println(sum);
    // }

    // private static boolean check(long val) {
    //     // TODO Auto-generated method stub
    //     long lastdigit = val%10;
    //     val/=10;
    //     while(val>0){
    //         if(lastdigit==val%10){
    //             return true;
    //         }
    //         lastdigit = val%10;
    //         val/=10;
    //     }   
    //     return false;
    }
}
