import java.io.*;
import java.util.*;
 
public class Shortest_Routes_I {
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
        dfs(graph,1,distance);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<distance.length;i++){
            sb.append(distance[i]+" ");
        }
        System.out.println(sb);
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
		private InputStream stream;
		private byte[] buf = new byte[1 << 16];
		private int curChar, numChars;
 
		// standard input
		public FastIO() { this(System.in, System.out); }
		public FastIO(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}
		// file input
		public FastIO(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}
 
		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) { throw new InputMismatchException(); }
				if (numChars == -1) return -1;  // end of file
			}
			return buf[curChar++];
		}
 
		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c;
			do { c = nextByte(); } while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > ' ');
			return res.toString();
		}
		public int nextInt() {  // nextLong() would be implemented similarly
			int c;
			do { c = nextByte(); } while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}
		public double nextDouble() { return Double.parseDouble(next()); }
	}
 
}
