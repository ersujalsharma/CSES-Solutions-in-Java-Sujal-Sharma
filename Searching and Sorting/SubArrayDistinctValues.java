import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

public class SubArrayDistinctValues {
    public static void main(String[] args) {
        FastIO io = new FastIO();
		int n = io.nextInt();
		int k = io.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i] = io.nextInt();
		}
		// StringBuilder sb = new StringBuilder();
		// int count = 0;
		// for(int i=0;i<arr.length;i++){
		// 	HashSet<Integer> hashSet = new HashSet<>();
		// 	for(int j=i;j<arr.length;j++){
		// 		hashSet.add(arr[j]);
		// 		if(hashSet.size()>k) break;
		// 		count++;
		// 	}
		// }
		long count = help(arr,k);
		System.out.println(count);
    }	
 
    private static long help(int[] arr,int k) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		int i=0,j=0;
		int temp = 0;
		long count = 0;
		while(j<arr.length){
			temp++;
			hashmap.put(arr[j],hashmap.getOrDefault(arr[j], 0)+1);
			while(hashmap.size()>k){
				hashmap.put(arr[i],hashmap.get(arr[i])-1);
				if(hashmap.get(arr[i])==0){
					hashmap.remove(arr[i]);
				}
				temp--;
				i++;
			}
			count+=temp;
			j++;
		}
		return count;
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

}
