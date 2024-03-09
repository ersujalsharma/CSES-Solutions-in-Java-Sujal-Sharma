import java.io.*;
import java.util.*;

public class Playlist {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        HashMap<Integer,Boolean> hashmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int cur = 0;
        int j=0;
        for(int i=0;i<n;i++){
            int val = io.nextInt();
            list.add(val);
            if(!hashmap.containsKey(val) ||  hashmap.get(val)==false){
                hashmap.put(val, true);
                cur++;
                max = Math.max(cur,max);
            }
            else{
                while(list.get(j)!=val){
                    hashmap.put(list.get(j), false);
                    j++;
                }
                cur = i-j;
                j++;
            }
        }
        io.print(max);
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
