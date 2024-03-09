import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FactoryMachine {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int t = io.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = io.nextInt();
        }
        String str = help(arr,t);
        io.print(str);
        io.close();
    }

    private static String help(int[] arr,int target) {
        
        Arrays.sort(arr);
        long min = 1;
        long max = (long)target*arr[0];
        while(min<=max){
            long mid = min+(max-min)/2;
            long total = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]<=mid){
                    total += mid/arr[j];
                }
                else{
                    break;
                }
            }
            if(total>=target){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
            // System.out.println(i +" "+total);
        }
        return max+1+"";
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
