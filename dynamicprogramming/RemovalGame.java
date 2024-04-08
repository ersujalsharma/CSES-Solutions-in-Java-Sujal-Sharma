import java.util.Arrays;
import java.util.Scanner;

public class RemovalGame {
    static long dp[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        dp = new long[arr.length][arr.length];
        for(long i[] : dp) Arrays.fill(i, -1);
        long val = help(arr,0,arr.length-1,dp);
        System.out.println(val);
    }
    private static long help(int[] arr, int i, int j,long [][]dp) {
        // TODO Auto-generated method stub
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        long takeLeft = arr[i] + Math.min(
            help(arr, i+2, j,dp), // arr[i+1]; -> as second person
            help(arr, i+1, j-1,dp)); // arr[j]; -> 
        long takeRight = arr[j] + Math.min(
            help(arr, i+1, j-1,dp), // arr[i]
            help(arr, i, j-2,dp)
        );
        return dp[i][j] = Math.max(takeLeft,takeRight);
    }
}
