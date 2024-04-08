

import java.util.Arrays;
import java.util.Scanner;

public class Rectangle_Cutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long dp[][] = new long[a+1][b+1];
        for(long d[] : dp)
            Arrays.fill(d,-1);
        long val = help(a,b,dp);
        System.out.println(val);
    }

    private static long help(int a, int b,long[][] dp) {
        // TODO Auto-generated method stub
        if(a==b) return 0;
        if(dp[a][b]!=-1) return dp[a][b];
        long count = Integer.MAX_VALUE;
        for(int i=1;i<=a/2;i++){
            long count1 = help(i,b,dp)+help(a-i,b,dp);
            count = Math.min(count,count1);
        }
        for(int i=1;i<=b/2;i++){
            long count1 = help(a,i,dp)+help(a,b-i,dp);
            count = Math.min(count,count1);
        }
        return dp[a][b] = count+1;
    }
}
