import java.io.*;
import java.util.*;
 
public class Maximum_SubArray_Sum_II {
    public static void main(String[] args) {
		final long LINF = Long.MIN_VALUE;
        FastIO scanner = new FastIO();
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

		long arr[] = new long[N];
		for(int i=0;i<N;i++){
			arr[i] = scanner.nextInt(); 
		}
 
        Deque<Integer> dq = new ArrayDeque<>();

        // Initialize a prefixSum array to store cumulative sums
        long[] prefixSum = new long[N + 1];

        // Initialize the answer to track the maximum sum
        long ans = Long.MIN_VALUE;

        // Calculate cumulative sums
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + arr[i - 1];
        }

        // Loop through the first (B-1) indices to initialize deque
        for (int i = 1; i < B; i++) {
            // Maintain deque in increasing order of prefix sum values
            while (!dq.isEmpty() && prefixSum[dq.peekFirst()] <= prefixSum[i]) {
                dq.pollFirst();
            }
            dq.addFirst(i);
        }

        // Loop through each starting index i from 0 to (N - A)
        for (int i = 0; i <= (N - A); i++) {
            // Maintain deque in increasing order of prefix sum values
            while (i + B <= N && !dq.isEmpty() && prefixSum[dq.peekFirst()] <= prefixSum[i + B]) {
                dq.pollFirst();
            }

            // Push the right end index to the front of deque
            if (i + B <= N)
                dq.addFirst(i + B);

            // If the index of maximum element outside the
            // current window, pop elements from the back of
            // the deque until the back index (index of maximum
            // element) is within the current window.
            while (!dq.isEmpty() && dq.peekLast() < (A + i)) {
                dq.pollLast();
            }

            // Update the answer by taking the maximum of the
            // current answer and the difference between the
            // prefix sum at the back (maximum element) of the
            // deque and the prefix sum at index i
            ans = Math.max(ans, prefixSum[dq.peekLast()] - prefixSum[i]);
        }

        // Print the final answer
        System.out.println(ans);
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
