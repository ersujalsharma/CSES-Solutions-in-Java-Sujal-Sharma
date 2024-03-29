import java.io.*;
import java.util.*;
 
public class Missing_Coin_Sum {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = io.nextInt();
        }
        long ans = help(arr);
        System.out.println(ans);
		io.close();
    }
    private static long help(int[] arr) {
        long sum = 1;
        Arrays.sort(arr);
        for(int i:arr){
            if(i>sum) break;
            sum+=i;
        }
        return sum;
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
