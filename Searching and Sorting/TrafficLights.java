import java.io.*;
import java.util.*;
 
public class TrafficLights {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] operations = new int[n];
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(x);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            operations[i] = a;
            set.add(a);
        }
        int[] gapsArr = new int[n];
        int previous = 0;
        int max = 0;
        for (int i : set) {
            max = Math.max(i - previous, max);
            previous = i;
        }
        gapsArr[n - 1] = max;
        for (int i = n - 1; i > 0; i--) {
            set.remove(operations[i]);
            int low = set.lower(operations[i]);
            int high = set.higher(operations[i]);
            max = Math.max(max, high - low);
            gapsArr[i - 1] = max;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : gapsArr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    // public static void main(String[] args) {
    //     Kattio io = new Kattio();
    //     int n = io.nextInt();
    //     int x = io.nextInt();
    //     NavigableSet<Integer> treeSet = new TreeSet<>();
    //     treeSet.add(0);
    //     treeSet.add(n);
    //     StringBuilder sb = new StringBuilder();
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    //     pq.add(n);
    //     for(int i=0;i<x;i++){
    //         // System.out.println(treeSet);
    //         // System.out.println(pq);
    //         int val = io.nextInt();
    //         int lowerbound = treeSet.floor(val);
    //         int upperbound = treeSet.ceiling(val);
    //         // System.out.println(lowerbound+"-"+upperbound);
    //         int preval = upperbound-lowerbound;
    //         pq.remove(preval);
    //         pq.add(val-lowerbound);
    //         pq.add(upperbound-val);
    //         treeSet.add(val);
    //         sb.append(pq.peek()+" ");
    //     }
    //     sb.deleteCharAt(sb.length()-1);
    //     io.print(sb);
    //     io.close();
    // }
    // static class Kattio extends PrintWriter {
	// 	private BufferedReader r;
	// 	private StringTokenizer st;
	// 	// standard input
	// 	public Kattio() { this(System.in, System.out); }
	// 	public Kattio(InputStream i, OutputStream o) {
	// 		super(o);
	// 		r = new BufferedReader(new InputStreamReader(i));
	// 	}
	// 	// USACO-style file input
	// 	public Kattio(String problemName) throws IOException {
	// 		super(problemName + ".out");
	// 		r = new BufferedReader(new FileReader(problemName + ".in"));
	// 	}
	// 	// returns null if no more input
	// 	public String next() {
	// 		try {
	// 			while (st == null || !st.hasMoreTokens())
	// 				st = new StringTokenizer(r.readLine());
	// 			return st.nextToken();
	// 		} catch (Exception e) { }
	// 		return null;
	// 	}
	// 	public int nextInt() { return Integer.parseInt(next()); }
	// 	public double nextDouble() { return Double.parseDouble(next()); }
	// 	public long nextLong() { return Long.parseLong(next()); }
	// }


}