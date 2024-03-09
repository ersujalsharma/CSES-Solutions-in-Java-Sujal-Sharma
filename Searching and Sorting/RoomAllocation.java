import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class RoomAllocation {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
		StringBuilder sb = new StringBuilder();
		int arr[][] = new int[n][3];
		for(int i=0;i<n;i++){
			arr[i][0] = io.nextInt();
			arr[i][1] = io.nextInt();
			arr[i][2] = i;
		}
		int ans[] = new int[n];
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		PriorityQueue<Room> pq = new PriorityQueue<>((a,b)->a.dep-b.dep);
		pq.add(new Room(arr[0][1],1));
		ans[arr[0][2]] = 1;
		int unused =2;
		for(int i=1;i<arr.length;i++){
			if(pq.peek().dep<arr[i][0]){
				pq.add(new Room(arr[i][1],pq.peek().roomno));
				ans[arr[i][2]] = pq.peek().roomno;
				pq.remove();
			}
			else{
				pq.add(new Room(arr[i][1], unused));
				ans[arr[i][2]] = unused++;
			}
		}
		sb.append(unused-1+"\n");
		for(int i=0;i<arr.length;i++){
			sb.append(ans[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		io.close();
    }
	static class Room{
		int dep;
		int roomno;
		public Room(int dep,int roomno){
			this.dep = dep;
			this.roomno = roomno;
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
