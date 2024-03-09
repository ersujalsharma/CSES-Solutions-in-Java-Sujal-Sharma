import java.io.*;
import java.util.*;

public class Collecting_Numbers {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(io.nextInt());
        }
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while(!list.isEmpty()){
            stack.clear();
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                if(stack.isEmpty() || stack.peek()<=list.get(i)){
                    stack.push(list.get(i));
                }
                else{
                    list2.add(list.get(i));
                }
            }
            list = list2;
            count++;
        }
        io.print(count);
        */
        int arr[] =  new int[n+1];
        arr[0] = 1;
        for(int i=1;i<=n;i++){
            arr[io.nextInt()] = i;
        }
        int ans = 1;
        for(int i=1;i<=n;i++){
            if(arr[i-1]>arr[i]) ans++;
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
