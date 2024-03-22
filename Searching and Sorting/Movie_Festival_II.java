import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class Movie_Festival_II {
    public static void main(String[] args) {
        FastIO io = new FastIO();
		int n = io.nextInt();
		int k = io.nextInt();
		Interval[] movies = new Interval[n];
		for (int i = 0; i < n; i++) {
			movies[i] = new Interval(io.nextInt(), io.nextInt());
		}
		// sort movies based on end time
		Arrays.sort(movies, Comparator.comparingInt(movie -> movie.end));

		int maxMovies = 0;
		// times when members will finish watching their movies
		TreeMap<Integer, Integer> endTimes = new TreeMap<>();
		endTimes.put(0, k);  // initialize all members at time 0

		for (Interval movie : movies) {
			// find member who finished watching their assigned movies the
			// latest before movie.start
			Integer lower = endTimes.floorKey(movie.start);

			// if such member exists, assign the member to the current movie
			if (lower != null) {
				maxMovies++;
				int lowerValue = endTimes.get(lower);
				// remove the original time in which member finishes movie
				if (lowerValue - 1 == 0) {
					endTimes.remove(lower);
				} else {
					endTimes.put(lower, lowerValue - 1);
				}
				// member now finishes watching at time movie.end
				endTimes.put(movie.end,
				             endTimes.getOrDefault(movie.end, 0) + 1);
			}
		}
		io.println(maxMovies);
		io.close();
    }
		static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
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
