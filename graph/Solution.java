import java.io.*;
import java.util.*;

public class Solution {
    static int par[];
    static boolean vis[];
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        par = new int[n+1];
        vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                detectCycle(graph, i, -1);
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void detectCycle(ArrayList<Integer>[] graph, int i,int parent) {
        // TODO Auto-generated method stub
        par[i] = parent;
        vis[i] = true;
        for(int n : graph[i]){
            if(!vis[n]) detectCycle(graph,n,i);
            else if(n!=parent){
                ArrayList<Integer> list = new ArrayList<>();
                int cur = i;
                list.add(cur);
                while(par[cur]!=n){
                    cur = par[cur];
                    list.add(cur);
                }
                list.add(n);
                list.add(i);
                System.out.print(list.size()+"\n");
                for(int l : list){
                    System.out.print(l+" ");
                }
                System.exit(0);
            }
        }
    }
      static class FastIO extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public FastIO() { this(System.in, System.out); }
		public FastIO(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public FastIO(String problemName) throws IOException {
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
