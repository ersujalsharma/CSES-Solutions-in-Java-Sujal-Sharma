import java.io.*;
import java.util.*;

/**
 * Sum_of_Three_Values
 */
public class Sum_of_Three_Values {

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int x = io.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0;i<arr.length;i++){
            arr[i][0] = io.nextInt();
            arr[i][1] = i;
        }
        String str = help(arr,x);
        io.print(str);
        io.close();
    }

    private static String help(int[][] arr,int target) {
        
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=0;i<arr.length;i++){
            int j=i+1,k=arr.length-1;
            while(j<k){
                if(arr[i][0]+arr[j][0]+arr[k][0]==target){
                    return (arr[i][1]+1)+" "+(arr[j][1]+1)+" "+(arr[k][1]+1);
                }
                else if(arr[i][0]+arr[j][0]+arr[k][0]<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
    
}