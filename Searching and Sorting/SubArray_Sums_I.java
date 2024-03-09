import java.io.*;
import java.util.*;

public class SubArray_Sums_I  {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int target = io.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = io.nextInt();
        }
        long ans = help(arr,target);
        System.out.println(ans);
        io.close();
    }
    private static long help(int[] arr,int target) {
        int i=0,j=0;
        int ans = 0,sum=0;
        while(j<arr.length){
            sum+=arr[j];
            while(sum>target){
                sum-=arr[i];
                i++;
            }
            if(sum<target){
                j++;
                continue;
            }
            if(sum==target) ans++;
            else{
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return ans;
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
