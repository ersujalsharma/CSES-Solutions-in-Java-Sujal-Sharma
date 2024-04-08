import java.io.*;
import java.util.*;

public class Array_Description {
	public static final int MOD = (int)1e9 + 7;
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        long dp[][] = new long[arr.length+1][m+1];
        for(long i[] : dp) Arrays.fill(i,-1);
        long val = memoized(arr,0,0,m,dp);
        // long val = tabularized(arr,m);
        System.out.println(val);
	}

    // private static long tabularized(int[] arr, int m) {
    //     // TODO Auto-generated method stub
    //     long dp[][] = new long[arr.length+1][m+1];
    //     Arrays.fill(dp[arr.length],1);    
    //     for(int index=arr.length-1;index>=0;index--){
    //         int x = arr[index];
    //         long count = 0;
    //         if(x!=0){
    //             // if(index>0 && Math.abs(arr[index]-arr[index-1])>1) return 0;
    //             count = dp[index+1][arr[index]];
    //         }
    //         else{         
    //             for(int prev=m;prev>=0;prev--){
    //                 int from = 1;
    //                 int to = m;
    //                 if(prev!=0){
    //                     from = prev-1>0?prev-1:prev;
    //                     to  = prev+1<=m?prev+1:prev;
    //                 }
    //                 for(int num = from;num<=to;num++){
    //                     arr[index] = num;
    //                     count += dp[index+1][num];
    //                     count %= MOD;
    //                 }
    //                 arr[index] = 0;
    //             } 
    //             dp[index][prev] = count;
    //         }
    //         dp[index][arr]
    //     }
    //     return dp[0][0];
    // }

    private static long memoized(int[] arr, int index,int prev,int m,long dp[][]) {
        // TODO Auto-generated method stub
        if(arr.length == index) return 1;
        if(dp[index][prev]!=-1) return dp[index][prev];
        int x = arr[index];
        long count = 0;
        if(x!=0){
            if(index>0 && Math.abs(arr[index]-arr[index-1])>1) return 0;
            count = memoized(arr, index+1, arr[index],m,dp);
        }
        else{
            int from = 1;
            int to = m;
            if(prev!=0){
                from = prev-1>0?prev-1:prev;
                to  = prev+1<=m?prev+1:prev;
            }
            for(int num = from;num<=to;num++){
                arr[index] = num;
                count += memoized(arr, index+1, num, m,dp);
                count %= MOD;
            }
            arr[index] = 0;
        } 
        return dp[index][prev] = count;
    }
}