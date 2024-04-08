import java.io.*;
import java.util.*;
public class Apartments {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FastIO fastIO = new FastIO();
        int n = fastIO.nextInt();
        int m = fastIO.nextInt();
        int k = fastIO.nextInt();
        // String[] in_var = bufferedReader.readLine().split(" ");
        // String[] in_req_sizes = bufferedReader.readLine().split(" ");
        // String[] in_apt_sizes = bufferedReader.readLine().split(" ");
 
        // int n = Integer.parseInt(in_var[0]);
        // int m = Integer.parseInt(in_var[1]);
        // int k = Integer.parseInt(in_var[2]);
 
        List<Integer> req_sizes = new ArrayList<>();
        List<Integer> apt_sizes = new ArrayList<>();
 
        // for (int i=0;i<n;i++)
        //     req_sizes.add(Integer.parseInt(in_req_sizes[i]));
 
        // for (int j=0;j<m;j++)
        //     apt_sizes.add(Integer.parseInt(in_apt_sizes[j]));
 
        for(int i=0;i<n;i++){
            req_sizes.add(fastIO.nextInt());
        }
        for(int i=0;i<m;i++){
            apt_sizes.add(fastIO.nextInt());
        }

        Solver solver = new Solver();
        System.out.println(solver.solve(req_sizes,apt_sizes,n,m,k));
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
 
class Solver{
    int solve(List<Integer> req_sizes, List<Integer> apt_sizes, int n, int m, int k){
        int count=0;
        int range;
 
        Collections.sort(req_sizes);
        Collections.sort(apt_sizes);
        int i=0,j=0;
        int a,b;
        while(i<n && j<m){
            a=apt_sizes.get(j);
            b=req_sizes.get(i);
            range=range(a,b,k);
            if (range==0){
                i++;
                j++;
                count++;
            }else if(range==-1){
                i++;
            }else j++;
        }
        return count;
    }
    int range(int a, int b, int k){
        if (a>=b-k){
            if (a<=b+k)
                return 0;
            else
                return -1;
        }else return 1;
    }
}
