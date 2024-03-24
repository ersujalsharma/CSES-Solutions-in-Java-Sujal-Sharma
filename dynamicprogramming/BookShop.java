import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int h[] = new int[n];
        int s[] = new int[n];
        for(int i=0;i<h.length;i++){
            h[i] = scanner.nextInt();
        }
        for(int i=0;i<h.length;i++){
            s[i] = scanner.nextInt();
        }
        // long dp[][] = new long[x+1][h.length];
        // for(long i[] : dp) Arrays.fill(i,-1);
        // long val = memoized(h,s,x,h.length-1,dp);
        long val = tabularized2(h,s,x);
        System.out.println(val);
    }

    private static long tabularized2(int[] h, int[] s, int x) {
        // TODO Auto-generated method stub
        int[] dp = new int[x + 1];
        for (int i = 0; i <= x; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < h.length; i++) {
            for (int j = x; j >= h[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - h[i]] + s[i]);
            }
        }

        return dp[x];
    }

    // private static long tabularized(int[] h, int[] s, int x) {
    //     // TODO Auto-generated method stub
    //     long dp[][] = new long[x+1][h.length];
    //     for(int i=0;i<=x;i++){
    //         if(h[0]<=i){
    //             dp[i][0] = s[0];
    //         }
    //     }
    //     for(int i=1;i<h.length;i++){
    //         for(int j=0;j<=x;j++){
    //             long take = 0;
    //             if(h[i]<=j){
    //                 take = s[i] + dp[j-h[i]][i-1];
    //             }
    //             long notTake = dp[j][i-1];
    //             dp[j][i] = Math.max(take,notTake);
    //         }
    //     }
    //     return dp[x][h.length-1];
    // }

    // private static long memoized(int[] h, int[] s, int x, int i,long[][] dp) {
    //     // TODO Auto-generated method stub
    //     if(i==0){
    //         if(h[i]<=x){
    //             return s[i];
    //         }
    //         return 0;
    //     }
    //     if(dp[x][i]!=-1) return dp[x][i];
    //     long take = 0;
    //     if(h[i]<=x){
    //         take = s[i] + memoized(h,s,x-h[i],i-1,dp);
    //     }
    //     long notTake = memoized(h,s,x,i-1,dp);
    //     return dp[x][i] = Math.max(take,notTake);
    // }
}
