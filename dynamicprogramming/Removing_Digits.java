package dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;

public class Removing_Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // int val = memoized(n,dp);
        int val = tabulization(n);
        System.out.println(val);
    }

    private static int tabulization(int n) {
        // TODO Auto-generated method stub
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int temp = i;
            int min = Integer.MAX_VALUE;
            while(temp>0){
                int rem = temp%10;
                if(rem!=0 && i-rem>=0){
                    min = Math.min(min,1+dp[i-rem]);
                }
                temp = temp/10;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // private static int memoized(int n,int dp[]) {
    //     // TODO Auto-generated method stub
    //     if(n==0){
    //         return 0;
    //     }
    //     if(dp[n]!=-1) return dp[n];
    //     int temp = n;
    //     int min = Integer.MAX_VALUE;
    //     while(temp>0){
    //         int rem = temp%10;
    //         if(rem!=0 && n-rem>=0){
    //             min = Math.min(min,1+memoized(n-rem,dp));
    //         }
    //         temp = temp/10;
    //     }
    //     return dp[n] = min;
    // }
}
