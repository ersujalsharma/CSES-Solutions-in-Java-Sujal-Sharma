import java.io.*;
import java.util.*;
 
public class Shortest_Routes_I_Optimized {
    static class Pair{
        int vertex;
        long distance;
        public Pair(int vertex,long distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Pair> graph[] = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        long distance[] = new long[n+1];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[1] = 0;
        for(int i=0;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long c = scanner.nextInt();
            graph[a].add(new Pair(b,c));
        }
        bfs(graph,distance);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<distance.length;i++){
            sb.append(distance[i]+" ");
        }
        System.out.println(sb);
    }
    private static void bfs(ArrayList<Solution.Pair>[] graph, long[] distance) {
        // TODO Auto-generated method stub
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.distance, b.distance));
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            if(popped.distance!=distance[popped.vertex]) continue;
            for(Pair neighbour : graph[popped.vertex]){
                if(popped.distance+neighbour.distance<distance[neighbour.vertex]){
                    distance[neighbour.vertex] = popped.distance+neighbour.distance;
                    pq.add(new Pair(neighbour.vertex, popped.distance+neighbour.distance));
                }
            }
        }
    }
    private static void dfs(ArrayList<Pair>[] graph, int src, long[] distance) {
        // TODO Auto-generated method stub
        for(Pair p : graph[src]){
            if(distance[src]+p.distance<distance[p.vertex]){
                distance[p.vertex] = distance[src]+p.distance;
                dfs(graph,p.vertex,distance);
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
