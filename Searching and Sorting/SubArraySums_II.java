import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * SubArraySums_II
 */
public class SubArraySums_II {

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int x = io.nextInt();
        HashMap<Long,Integer> hashmap = new HashMap<>();
        hashmap.put(0l,1);
        long ans = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=io.nextInt();
            if(hashmap.containsKey(sum-x)){
                ans += hashmap.get(sum-x);
            }
            hashmap.put(sum, hashmap.getOrDefault(sum, 0)+1);
        }
        io.print(ans);
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