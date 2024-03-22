import java.util.Arrays;
import java.util.Scanner;

class MinimizingCoins {
    // static long dp[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        // dp = new long[n][x+1];
        // for(int i=1;i<=x;i++){
        //     if(i%arr[0]==0) dp[0][i] = i/arr[0];
        // }
        // for(long d[] : dp) Arrays.fill(d,-1);
        // long val = dp[arr.length-1][x];
        // long val = memoized(arr,arr.length-1,x);
        long val = tabularizedOptimized(arr, x);
        System.out.println(val == Integer.MAX_VALUE?-1:val);
    }

    private static long tabularizedOptimized(int[] arr,int x){
        long prev[] = new long[x+1];
        for(int i=1;i<=x;i++){
            if(i%arr[0] == 0) prev[i] = i/arr[0];
            else{ 
                prev[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=1;i<arr.length;i++){
            long current[] = new long[x+1];
            for(int j=1;j<=x;j++){
                long take = Integer.MAX_VALUE;
                if(arr[i]<=j){
                    // System.out.println(arr[i]);
                    take =  current[j-arr[i]];
                    if(take != Integer.MAX_VALUE){
                        take = 1 + take;
                    }
                }
                long notTake = prev[j];
                current[j] = Math.min(take,notTake);
            }    
            prev = current;
        }
        long val = prev[x];
        return val;
    }

    
    // private static long tabularized(int[] arr,int x){
    //     for(int i=1;i<=x;i++){
    //         if(i%arr[0] == 0) dp[0][i] = i/arr[0];
    //         else{ 
    //             dp[0][i] = Integer.MAX_VALUE;
    //         }
    //     }
        
    //     for(int i=1;i<arr.length;i++){
    //         for(int j=1;j<=x;j++){
    //             long take = Integer.MAX_VALUE;
    //             if(arr[i]<=j){
    //                 // System.out.println(arr[i]);
    //                 take =  dp[i][j-arr[i]];
    //                 if(take != Integer.MAX_VALUE){
    //                     take = 1 + take;
    //                 }
    //             }
    //             long notTake = dp[i-1][j];
    //             dp[i][j] = Math.min(take,notTake);
    //         }    
    //     }
    //     long val = dp[arr.length-1][x];
    //     return val;
    // }

    // private static long memoized(int[] arr, int i, int x) {
    //     // TODO Auto-generated method stub
    //     if(i==0){
    //         if(x % arr[i] == 0) return x / arr[i];
    //         return Integer.MAX_VALUE;
    //     }
    //     if(x==0) return 0;
    //     if(dp[i][x]!=-1) return dp[i][x];
    //     long take = Integer.MAX_VALUE;
    //     if(arr[i]<=x){
    //         // System.out.println(arr[i]);
    //         take =  memoized(arr, i, x-arr[i]);
    //         if(take != Integer.MAX_VALUE){
    //             take = 1 + take;
    //         }
    //     }    
    //     long notTake = memoized(arr, i-1, x);
    //     return dp[i][x] = Math.min(take,notTake);
    // }
    
}
