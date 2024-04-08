import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Increasing_Subsequence {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(reader.readLine());
        // int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // long dp[][] = new long[arr.length][arr.length];
        // for(long i[] : dp) Arrays.fill(i,-1);
        // long val = help(arr,0,-1,dp);
        long val = tabularized(arr);
        System.out.println(val);
    }

    private static long tabularized(int[] arr) {
        // TODO Auto-generated method stub
        // int next[] = new int[arr.length+1];
        // for(int i=arr.length-1;i>=0;i--){
        //     for(int j=-1;j<i;j++){
        //         int notTake = next[j+1];
        //         int take = 0;
        //         if(j==-1 || arr[j]<arr[i]){
        //             take = 1 + next[i+1];
        //         }
        //         next[j+1] =  Math.max(take,notTake);
        //     }
        // }
        // return next[0];
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int index = Collections.binarySearch(lis, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == lis.size()) {
                lis.add(num);
            } else {
                lis.set(index, num);
            }
        }

        return lis.size();
    }

    // private static long help(int[] arr, int i, int j,long[][] dp) {
    //     // TODO Auto-generated method stub
    //     if(i==arr.length){
    //         return 0;
    //     }
    //     if(dp[i][j+1]!=-1) return dp[i][j+1];
    //     long notTake = help(arr,i+1,j,dp);
    //     long take = 0;
    //     if(j==-1 || arr[j]<arr[i]){
    //         take = 1 + help(arr, i+1, i, dp);
    //     }
    //     return dp[i][j+1] =  Math.max(take,notTake);
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
