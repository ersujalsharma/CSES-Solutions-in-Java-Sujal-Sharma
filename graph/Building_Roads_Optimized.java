import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Building_Roads_Optimized {
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] edges[] = new int[m][2];
        for(int i=0;i<edges.length;i++){
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int edge[] : edges){
            graph[edge[0]-1].add(edge[1]-1);
            graph[edge[1]-1].add(edge[0]-1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,i,visited);
                list.add(i+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()-1+"\n");
        for(int i=0;i<list.size()-1;i++){
            sb.append(list.get(i)+" "+list.get(i+1)+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    private static void dfs(ArrayList<Integer>[] graph, int i, boolean[] visited) {
        // TODO Auto-generated method stub
        visited[i] = true;
        for(int n : graph[i]){
            if(!visited[n]){
                dfs(graph,n,visited);
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

