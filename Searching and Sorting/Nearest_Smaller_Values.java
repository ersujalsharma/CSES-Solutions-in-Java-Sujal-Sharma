import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Nearest_Smaller_Values {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;i++){
			arr[i] = io.nextInt();
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
				stack.pop();
			}
			sb.append(stack.isEmpty()?0:stack.peek()+1);
			sb.append(" ");
			stack.push(i);
		}
		sb.deleteCharAt(sb.length()-1);
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
