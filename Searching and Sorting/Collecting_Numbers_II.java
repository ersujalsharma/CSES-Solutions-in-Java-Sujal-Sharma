import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Collecting_Numbers_II {
        public static void main(String[] args) {
        FastIO io = new FastIO();
		int n = io.nextInt();
		int k = io.nextInt();
		int arr[] = new int[n+1];
		int index[] = new int[n+2];
		index[n+1] = n+1;
		for(int i=1;i<=n;i++){
			arr[i] = io.nextInt();
			index[arr[i]] = i;
		}
		int ans = 1;
		for(int i=1;i<=n;i++){
			if(index[i-1]>index[i]){
				ans++;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(k-->0){
			int x = io.nextInt();
			int y = io.nextInt();
			int xindex = arr[x];
			int yindex = arr[y];
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
			if(index[xindex-1]<=index[xindex] && index[xindex-1] > y) ans++;
			if(index[xindex-1]>index[xindex] && index[xindex-1] <=y) ans--;
			if(index[xindex] <= index[xindex+1] && y > index[xindex+1]) ans++;
			if(index[xindex] > index[xindex+1] && y <= index[xindex+1]) ans--;
			index[xindex] = y;
			if(index[yindex-1]<=index[yindex] && index[yindex-1] > x) ans++;
			if(index[yindex-1]>index[yindex] && index[yindex-1] <=x) ans--;
			if(index[yindex] <= index[yindex+1] && x > index[yindex+1]) ans++;
			if(index[yindex] > index[yindex+1] && x <= index[yindex+1]) ans--;
			index[yindex] = x;
			sb.append(ans+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
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
