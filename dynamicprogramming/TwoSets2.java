import java.util.Arrays;
import java.util.Scanner;

public class TwoSets2 {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = (n * (n + 1)) / 2;
        if ((sum & 1) != 0) {
            System.out.println(0);
            return;
        }
        // long dp[][] = new long[n + 1][(sum / 2) + 1];
        // for(long d[] : dp) Arrays.fill(d,-1);
        // long ans = help(n, sum / 2, dp);
        long ans = tabularized2(n,sum/2);
        System.out.println(ans);
    }

    private static long tabularized2(int n, int target) {
        // TODO Auto-generated method stub
        long prev[] = new long[target + 1];
        prev[0] = 1;
        for(int i=1;i<=n;i++){
            if(i!=1)
                prev[0] = 0;
            for(int j=target;j>=1;j--){
                long notTake = prev[j];
                long take = 0;
                if (j >= i)
                    take = prev[j - i];
                prev[j] = (notTake + take) % MOD;
            }
        }cses
        return prev[target];
    }

    // private static long tabularized(int n, int target) {
    //     // TODO Auto-generated method stub
    //     long dp[][] = new long[n + 1][target + 1];
    //     dp[0][0] = 1;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=target;j++){
    //             long notTake = dp[i - 1][j];
    //             long take = 0;
    //             if (j >= i)
    //                 take = dp[i - 1][j - i];
    //             dp[i][j] = (notTake + take) % MOD;
    //         }
    //     }
    //     return dp[n][target];
    // }

    private static long help(int n, int target, long[][] dp) {
        // TODO Auto-generated method stub
        if (n == 0) {
            if (target == 0)
                return 1;
            return 0;
        }
        if(dp[n][target]!=-1) return dp[n][target];
        long notTake = help(n - 1, target, dp);
        long take = 0;
        if (target >= n)
            take = help(n - 1, target - n, dp);
        return dp[n][target] = (notTake + take) % MOD;
    }
}
