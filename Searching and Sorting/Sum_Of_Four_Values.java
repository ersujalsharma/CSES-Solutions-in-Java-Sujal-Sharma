import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Sum_Of_Four_Values {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
		int target = io.nextInt();
		int arr[][] = new int[n][2];
		for(int i=0;i<arr.length;i++){
			arr[i][0] = io.nextInt();
			arr[i][1] = i+1;
		}
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		if(n<4){
			System.out.println("IMPOSSIBLE");
			return;
		}
		else{
			for(int i=0;i<arr.length;i++){
				int first = arr[i][0];
				for(int j=i+1;j<arr.length;j++){
					int second = arr[j][0];
					int k=j+1,l=arr.length-1;
					while(k<l){
						if(first+second+arr[k][0]+arr[l][0]== target){
							System.out.println((arr[i][1])+" "+(arr[j][1])+" "+(arr[k][1])+" "+(arr[l][1]));
							return;
						}
						else if(first+second+arr[k][0]+arr[l][0]<target){
							k++;
						}
						else{
							l--;
						}
					}
				}
			}
		}linked
		
		System.out.println("IMPOSSIBLE");
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
