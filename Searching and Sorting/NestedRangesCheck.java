import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class NestedRangesCheck {
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = io.nextInt();
            arr[i][1] = io.nextInt();
            arr[i][2] = i;
        }
        int ans[][] = new int[2][n];
        Arrays.sort(arr,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int min = arr[arr.length-1][1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i][1]>=min){
                ans[0][arr[i][2]] = 1;
            }
            min = Math.min(arr[i][1],min);
        }
        int max = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][1]<=max){
                ans[1][arr[i][2]] = 1;
            }
            max = Math.max(arr[i][1],max);
        }

        // for(int i=0;i<arr.length;i++){
        //     int a = arr[i][0];
        //     int b = arr[i][1];
        //     for(int j=0;j<arr.length;j++){
        //         int c = arr[j][0];
        //         int d = arr[j][1];
        //         if(j!=i){
        //             if(a<=c && d<=b){
        //                 ans[0][i] = 1;
        //                 ans[1][j] = 1;
        //             }
        //         }
        //     }
        // }
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                io.print(ans[i][j]);
                if(j!=n-1) io.print(" ");
            }
            io.println();
        }
        io.close();
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // standard input
        public FastIO() {
            this(System.in, System.out);
        }

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
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() { // nextLong() would be implemented similarly
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
