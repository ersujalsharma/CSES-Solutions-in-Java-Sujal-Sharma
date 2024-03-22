import java.io.*;
import java.util.*;

public class Josephus_Problem_I {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		boolean lastFree = false;
		int start = 0;
		while(!list.isEmpty()){
			// start = (start+1)%list.size();
			// sb.append(list.remove(start)+" ");
			ArrayList<Integer> list2 = new ArrayList<>();
			if(lastFree){
				for(int i=0;i<list.size();i=i+2){
					sb.append(list.get(i)+" ");
					lastFree = false;
					if(i+1<list.size()){
						list2.add(list.get(i+1));
						lastFree = true;
					}
				}
			}
			else{
				for(int i=0;i<list.size();i=i+2){
					list2.add(list.get(i));
					lastFree = true;
					if(i+1<list.size()){
						sb.append(list.get(i+1)+" ");
						lastFree = false;
					}
				}
			}
			// System.out.println(list+" / "+list2+" / "+sb);
			list = list2;
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
