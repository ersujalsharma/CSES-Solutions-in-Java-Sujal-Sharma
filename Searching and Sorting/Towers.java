import java.io.*;
import java.util.*;
 
public class Towers {
    public static void main(String[] args) throws IOException {
 
		Kattio io = new Kattio();
		int n = io.nextInt();
		int[] cubes = new int[n];
		for (int i = 0; i < n; i++) { cubes[i] = io.nextInt(); }
		TreeMap<Integer, Integer> towers = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			// System.out.println(towers);
			// If there are no suitable towers, add another tower to the set
			if (towers.higherKey(cubes[i]) == null) {
				towers.put(cubes[i], towers.getOrDefault(cubes[i], 0) + 1);
			}
			// If there exists a satisfying tower, add the cube to that tower
			// and update the top element of the tower
			else {
				int size = towers.higherKey(cubes[i]);
				towers.put(size, towers.get(size) - 1);
				if (towers.get(size) == 0) { towers.remove(size); }
				towers.put(cubes[i], towers.getOrDefault(cubes[i], 0) + 1);
			}
		}
		// System.out.println(towers);
		int ans = 0;
		for(int i:towers.values()) ans+=i;
		// int ans = help(cubes);
		io.println(ans);
		io.close();
    }
 
    // private static int help(int[] arr) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i=0;i<arr.length;i++){
    //         int pos = search(list,arr[i]);
    //         if(pos>=list.size()){
    //             list.add(arr[i]);
    //         }
    //         else{
    //             list.set(pos, arr[i]);
    //         }
    //     }
    //     // System.out.println(list);
    //     return list.size();
    // }
 
    // private static int search(List<Integer> list, int num) {
    //     // TODO Auto-generated method stub
    //     int i=0,j=list.size()-1;
    //     while(i<=j){
    //         int mid = (i+j)/2;
    //         if(list.get(mid)<=num){
    //             i++;
    //         }
    //         else{
    //             j--;
    //         }
    //     }
    //     return j+1;
    // }
        
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
