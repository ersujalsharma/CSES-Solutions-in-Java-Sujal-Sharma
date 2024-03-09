import java.io.*;
import java.util.*;

public class Task_Deadlines {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
		int arr[][] = new int[n][2];
		for(int i=0;i<n;i++){
			arr[i][0] = io.nextInt();
			arr[i][1] = io.nextInt();
		}
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		long count = 0;
		long time = 0;
		for(int i=0;i<n;i++){
			time+=arr[i][0];
			count+=(arr[i][1]-time);
		}
        io.println(count);
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
