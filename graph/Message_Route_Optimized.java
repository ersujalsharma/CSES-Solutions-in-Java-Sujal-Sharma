import java.io.*;
import java.util.*;

public class Message_Route_Optimized {
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
        boolean visited[] = new boolean[n+1];
        int parent[] = new int[n+1];
        Arrays.fill(parent,Integer.MAX_VALUE);
        parent[1] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.level-b.level);
        pq.add(new Pair(1, 1));
        visited[1] = true;
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            if(popped.value == n){
                break;
            }
            for(int neighbour : graph[popped.value]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    parent[neighbour] = popped.value;
                    pq.add(new Pair(neighbour, popped.level+1));
                }
            }
        }
        if(parent[n] == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int val = n;
        int count = 1;
        while(parent[val]!=val){
            sb.insert(0, val+" ");
            val = parent[val];
            count++;
        }
        sb.insert(0,1+" ");
        System.out.println(count+"\n"+sb);
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