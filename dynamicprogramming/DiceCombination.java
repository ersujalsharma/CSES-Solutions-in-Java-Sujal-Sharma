package dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;

public class DiceCombination {
    static int MOD = 1000000007;
    static long dp[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        long ans = tabulation(n);
        System.out.println(ans);
    }

    private static long memoized(int n) {
        // TODO Auto-generated method stub
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        long count = 0;
        for(int i=1;i<=6;i++){
            if(n-i>=0){
                count += memoized(n-i);
                count %= MOD;
            }
            else{
                break;
            }
        }
        return dp[n] = count;
    }
    private static long tabulation(int n){
        long dp[] = new long[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=6 && i-j>=0;j++){
                dp[i] = (dp[i] + dp[i-j]) %MOD;
            }
        }
        return dp[n];
    }
}
