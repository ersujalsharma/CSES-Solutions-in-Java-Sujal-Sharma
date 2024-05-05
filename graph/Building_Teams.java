import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Building_Teams {
    static boolean possible = true;
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++) graph[i] = new ArrayList<>();
        for(int i =0;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean visited[] = new boolean[n+1];
        boolean team[] = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(graph,i,-1,team,visited);
            }
        }
        if(!possible){
            System.out.println("IMPOSSIBLE");
        }
        else{
            for(int i=1;i<=n;i++){
                System.out.print(team[i]?1+" ":2+" ");
            }
        }
    }

      private static void dfs(ArrayList<Integer>[] graph, int u, int parent, boolean[] team, boolean[] visited) {
        // TODO Auto-generated method stub
        for(int v : graph[u]){
            if(v!=parent){
                if(!visited[v]){
                    visited[v] = true;
                    team[v] = !team[u];
                    dfs(graph,v,u,team,visited);
                }
                else{
                    if(team[u] == team[v]){
                        possible = false;
                        return;
                    }
                }
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
