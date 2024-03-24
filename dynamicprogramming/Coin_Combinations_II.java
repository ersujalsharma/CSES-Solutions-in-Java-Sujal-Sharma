// package dynamicprogramming;

import java.io.*;
import java.util.*;

public class Coin_Combinations_II {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        // long dp[][] = new long[n][target+1];
        // for(long i[] : dp) Arrays.fill(i,-1);
        // long val = memoized(arr,target,arr.length-1,dp);
        // long val = tabulization(arr,target);
        long val = tabulizationOptimized2(arr, target);
        System.out.println(val);
    }

    private static long tabulizationOptimized2(int[] arr, int target) {
        // TODO Auto-generated method stub
        int prev[] = new int[target+1];
        prev[0] = 1;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j<=target;j++){
                if(j>=arr[i]){
                    prev[j] = (prev[j] + prev[j-arr[i]]) %MOD;
                }
            }
        }
        return prev[target];    
        // int[] dp = new int[target + 1];
		// dp[0] = 1;
		// for (int i = 0; i < arr.length; i++) {       // loop through coins
		// 	for (int w = arr[i]; w <= target; w++) {  // loop through sums
		// 		if (w - arr[i] >= 0) {    // prevent out of bounds cases
		// 			dp[w] = (dp[w] + dp[w - arr[i]]) % MOD;
		// 		}
		// 	}
		// }
		// return dp[target];
    }

    // private static long tabulizationOptimized(int[] arr, int target) {
    //     // TODO Auto-generated method stub
    //     // long dp[][] = new long[arr.length][target+1];
    //     long prev[] = new long[target+1];
    //     // for(int i=0;i<arr.length;i++){
    //     //     dp[i][0] = 1;
    //     // }
    //     for(int i=0;i<=target;i++){
    //         if(i%arr[0] == 0){
    //             // dp[0][i] = 1;
    //             prev[i] = 1;
    //         }
    //     }
    //     prev[0] = 1;
    //     // Arrays.sort(arr);
    //     for(int i=1;i<arr.length;i++){
    //         // long current[] = new long[target+1];
    //         for(int j=1;j<=target;j++){
    //             // long take = 0;
    //             if(arr[i]<=j){
    //                 // take = dp[i][j-arr[i]];
    //                 // take = current[j-arr[i]];
    //                 // take = prev[j-arr[i]];
    //                 prev[j] += prev[j-arr[i]];
    //             }
    //             // long notTake = dp[i-1][j];
    //                 // long notTake = prev[j];
    //             // dp[i][j] = ( take + notTake ) % MOD;
    //             // current[j] = ( take + notTake ) % MOD;
    //             // current[j] = take + notTake;
    //                 // prev[j] = take + notTake;
    //             // if(current[j]>=MOD){
    //             //     current[j] = current[j] - MOD;
    //             // }
    //             if(prev[j]>=MOD){
    //                 prev[j] -= MOD;
    //             }
    //         }
    //         // prev = current;
    //     }
    //             // return 0;
    //             // return dp[arr.length-1][target];
    //     return prev[target];    
    // }
    // private static long tabulization(int[] arr, int target) {
    //     // TODO Auto-generated method stub
    //     long dp[][] = new long[arr.length][target+1];
    //     // long prev[] = new long[target+1];
    //     for(int i=0;i<arr.length;i++){
    //         dp[i][0] = 1;
    //     }
    //     for(int i=0;i<=target;i++){
    //         if(i%arr[0] == 0){
    //             dp[0][i] = 1;
    //             // prev[i] = 1;
    //         }
    //     }
    //     for(int i=1;i<arr.length;i++){
    //         long current[] = new long[target+1];
    //         current[0] = 1;
    //         for(int j=1;j<=target;j++){
    //             long take = 0;
    //             if(arr[i]<=j){
    //                 take = dp[i][j-arr[i]];
    //                 // take = current[j-arr[i]];
    //             }
    //             long notTake = dp[i-1][j];
    //             // long notTake = prev[j];
    //             // dp[i][j] = ( take + notTake ) % MOD;
    //             current[j] = ( take + notTake ) % MOD;
    //         }
    //         // prev = current;
    //     }
    //     // return 0;
    //     return dp[arr.length-1][target];
    //     // return prev[target];
    // }
    // private static long memoized(int[] arr, int target, int i,long[][] dp) {
    //     // TODO Auto-generated method stub
    //     if(target == 0) return 1;
    //     if(i==0) {
    //         if(target%arr[i]==0){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(dp[i][target]!=-1) return dp[i][target];
    //     long take = 0;
    //     if(arr[i]<=target){
    //         take = memoized(arr, target-arr[i], i,dp);

    //     }
    //     long notTake = memoized(arr, target, i-1,dp);
    //     return dp[i][target] = ( take + notTake ) % MOD;
    // }

    // static class FastIO extends PrintWriter {
	// 	private InputStream stream;
	// 	private byte[] buf = new byte[1 << 16];
	// 	private int curChar, numChars;
 
	// 	// standard input
	// 	public FastIO() { this(System.in, System.out); }
	// 	public FastIO(InputStream i, OutputStream o) {
	// 		super(o);
	// 		stream = i;
	// 	}
	// 	// file input
	// 	public FastIO(String i, String o) throws IOException {
	// 		super(new FileWriter(o));
	// 		stream = new FileInputStream(i);
	// 	}
 
	// 	// throws InputMismatchException() if previously detected end of file
	// 	private int nextByte() {
	// 		if (numChars == -1) throw new InputMismatchException();
	// 		if (curChar >= numChars) {
	// 			curChar = 0;
	// 			try {
	// 				numChars = stream.read(buf);
	// 			} catch (IOException e) { throw new InputMismatchException(); }
	// 			if (numChars == -1) return -1;  // end of file
	// 		}
	// 		return buf[curChar++];
	// 	}
 
	// 	// to read in entire lines, replace c <= ' '
	// 	// with a function that checks whether c is a line break
	// 	public String next() {
	// 		int c;
	// 		do { c = nextByte(); } while (c <= ' ');
	// 		StringBuilder res = new StringBuilder();
	// 		do {
	// 			res.appendCodePoint(c);
	// 			c = nextByte();
	// 		} while (c > ' ');
	// 		return res.toString();
	// 	}
	// 	public int nextInt() {  // nextLong() would be implemented similarly
	// 		int c;
	// 		do { c = nextByte(); } while (c <= ' ');
	// 		int sgn = 1;
	// 		if (c == '-') {
	// 			sgn = -1;
	// 			c = nextByte();
	// 		}
	// 		int res = 0;
	// 		do {
	// 			if (c < '0' || c > '9') throw new InputMismatchException();
	// 			res = 10 * res + c - '0';
	// 			c = nextByte();
	// 		} while (c > ' ');
	// 		return res * sgn;
	// 	}
	// 	public double nextDouble() { return Double.parseDouble(next()); }
	// }

}
