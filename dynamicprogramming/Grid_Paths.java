package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Grid_Paths {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0;i<arr.length;i++){
            String str = scanner.next();
            for(int j=0;j<str.length();j++){
                arr[i][j] = str.charAt(j);
            }
        }
        long dp[][] = new long[n][n];
        for(long i[] : dp) Arrays.fill(i,-1);
        long val = memoized(arr,0,0,dp);
        System.out.println(val);
    }

    private static long memoized(char[][] arr, int i, int j,long dp[][]) {
        // TODO Auto-generated method stub
        if(i>arr.length-1 || j>arr.length-1 || arr[i][j]=='*'){
            return 0;
        }    
        if(i==arr.length-1 && j== arr.length-1){
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        long right = memoized(arr, i, j+1,dp);
        long down = memoized(arr, i+1, j,dp);
        return dp[i][j] = (right+down)%MOD;
    }

}
