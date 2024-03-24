package dynamicprogramming;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Coin_Combinations_I
 */
public class Coin_Combinations_I {
    // static long dp[];
    static int MOD = 1000000007;
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        // dp = new long[target+1];
        // Arrays.fill(dp,-1);
        // long val = memoized(arr,target);
        long val = tabularizedOptimized(arr,target);
        System.out.println(val);
    }

    private static long tabularizedOptimized(int[] arr, int target) {
        // TODO Auto-generated method stub
        long dp[] = new long[target+1];
        Arrays.sort(arr);
        dp[0] = 1;
        for(int j=1;j<=target;j++){
            long count = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]<=j){
                    count += dp[j-arr[i]];
                    // count %= MOD;
                    if (count >= MOD) {
                        count -= MOD;
                    }
                }
            }
            dp[j] =  count;
        }
        return dp[target];
    }

    // private static long tabularized(int[] arr, int target) {
    //     // TODO Auto-generated method stub
    //     long dp[] = new long[target+1];
    //     dp[0] = 1;
    //     for(int j=1;j<=target;j++){
    //         long count = 0;
    //         for(int i=0;i<arr.length;i++){
    //             if(arr[i]<=j){
    //                 count += dp[j-arr[i]];
    //                 count %= MOD;
    //             }
    //         }
    //         dp[j] =  count;
    //     }
    //     return dp[target];
    // }

    // private static long memoized(int[] arr, int target) {
    //     // TODO Auto-generated method stub
    //     if(target == 0) return 1;
    //     if(dp[target] != -1 )return dp[target];
    //     long count = 0;
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]<=target){
    //             count += memoized(arr, target-arr[i]);
    //             count %= MOD;
    //         }
    //     }
    //     return dp[target] =  count;
    // }
    
    static class FastIO extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1 << 16];
		private int curChar, numChars;
 
		// standard input
		public FastIO() { this(System.in, System.out); }
		public FastIO(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}
		// file input
		public FastIO(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}
 
		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) { throw new InputMismatchException(); }
				if (numChars == -1) return -1;  // end of file
			}
			return buf[curChar++];
		}
 
		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c;
			do { c = nextByte(); } while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > ' ');
			return res.toString();
		}
		public int nextInt() {  // nextLong() would be implemented similarly
			int c;
			do { c = nextByte(); } while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}
		public double nextDouble() { return Double.parseDouble(next()); }
	}

}