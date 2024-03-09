import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Array_Division {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
		int target = io.nextInt();
		int arr[] = new int[n];
		StringBuilder sb = new StringBuilder();
		long min = Integer.MIN_VALUE;
		long max = 0;
		for(int i=0;i<arr.length;i++){
			arr[i] = io.nextInt();
			min = Math.max(arr[i],min);
			max += arr[i];
		}
		if(n==target) sb.append(min);
		else{
			while(min<=max){
				long mid = min+(max-min)/2;
				int count = 1;
				long sum = 0;
				for(int j=0;j<arr.length;j++){
					sum+=arr[j];
					if(sum>mid){
						count++;
						sum = arr[j];
					}
				}
				if(sum>mid) count++;
				if(count <= target){
					max = mid-1;
				}
				else{
					min = mid+1;
				}
			}
			sb.append(max+1);
		}
		// sb.deleteCharAt(sb.length()-1);
        io.println(sb);
		io.close();
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
