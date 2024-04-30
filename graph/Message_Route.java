import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Message_Route {
     static class Pair{
        int value;
        int level;
        public Pair(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        FastIO scanner = new FastIO();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[][] = new int[m][2];
        for(int i=0;i<m;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            graph[arr[i][0]].add(arr[i][1]);
            graph[arr[i][1]].add(arr[i][0]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean visited[] = new boolean[n+1];
        searchPath(graph,1,ans,new ArrayList<>(),visited);
        int min = Integer.MAX_VALUE;
        List<Integer> listans = new ArrayList<>();
        for(List<Integer> l : ans){
            if(l.size()<min){
                min = l.size();
                listans = l;
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min+"\n");
        // System.out.println(min);
        for(int i : listans){
            sb.append(i+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    private static void searchPath(ArrayList<Integer>[] graph, int i, List<List<Integer>> ans, ArrayList<Integer> list,
            boolean[] visited) {
        // TODO Auto-generated method stub
        list.add(i);
        visited[i] = true;
        if(i==graph.length-1) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            visited[i] = false;
            return;
        }
        for(int neighbour : graph[i]){
            if(!visited[neighbour]){
                searchPath(graph,neighbour,ans,list,visited);
            }
        }
        list.remove(list.size()-1);
        visited[i] = false;
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
