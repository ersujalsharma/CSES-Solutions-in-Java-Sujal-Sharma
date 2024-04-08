import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int arr[][] = new int[t][3];
        for(int i=0;i<arr.length;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        // long dp[][] = new long[arr.length+1][arr.length+1];
        // for(long i[] : dp) Arrays.fill(i,-1);
        // long val = help(arr,0,-1,dp);
        long val = tabularized(arr);
        System.out.println(val);
    }

    private static long tabularized(int[][] arr) {
        // TODO Auto-generated method stub
        long next[] = new long[arr.length+1];
        for(int i=arr.length-1;i>=0;i--){
            for(int j=-1;j<i;j++){
                long notTake = next[j+1];
                long take = 0;
                if(j == -1 || arr[j][1]<arr[i][0]){
                    take = arr[i][2] + next[i+1];
                }
                next[j+1] = Math.max(take,notTake);
            }
        }
        return next[-1+1];
    }

    private static long help(int[][] arr, int index, int prev,long[][] dp) {
        // TODO Auto-generated method stub
        if(index == arr.length) return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        long notTake = help(arr, index+1, prev,dp);
        long take = 0;
        if(prev == -1 || arr[prev][1]<arr[index][0]){
            take = arr[index][2] + help(arr, index+1, index,dp);
        }
        return dp[index][prev+1] = Math.max(take,notTake);
    }

    
}
