import java.io.*;
import java.util.*;

public class Projects{
    public static void main(String[] args) {
        FastIO scanner = new FastIO();

        int n = Integer.parseInt(scanner.next());

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startDate = scanner.nextInt();
            int endDate = scanner.nextInt();
            int reward = scanner.nextInt();
            projects.add(new Project(startDate, endDate, reward));
        }

        Collections.sort(projects, new Comparator<Project>() {
            public int compare(Project p1, Project p2) {
                return Integer.compare(p1.endDate, p2.endDate);
            }
        });

        int[] startDates = new int[n];
        int[] endDates = new int[n];
        int[] rewards = new int[n];

        for (int i = 0; i < n; i++) {
            Project project = projects.get(i);
            startDates[i] = project.startDate;
            endDates[i] = project.endDate;
            rewards[i] = project.reward;
        }

        long[] maxMoney = new long[n];
        maxMoney[0] = rewards[0];

        for (int i = 1; i < n; i++) {
            // for each try to find is there any previous which we can start and end till now and get that score also.
            int pos = binarySearch(endDates, startDates[i] - 1);
            if (pos > 0) {
                long val = maxMoney[pos - 1] + rewards[i];
                maxMoney[i] = Math.max(val, maxMoney[i - 1]);
            } else {
                maxMoney[i] = Math.max(rewards[i], maxMoney[i - 1]);
            }
        }

        System.out.println(maxMoney[n - 1]);
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    static class Project {
        int startDate;
        int endDate;
        int reward;

        public Project(int startDate, int endDate, int reward) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.reward = reward;
        }
    }
    // public static void main(String[] args) {
    //     FastIO fastIO = new FastIO();
    //     int t = fastIO.nextInt();
    //     int arr[][] = new int[t][3];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i][0] = fastIO.nextInt();
    //         arr[i][1] = fastIO.nextInt();
    //         arr[i][2] = fastIO.nextInt();
    //     }
    //     Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    //     // long dp[][] = new long[arr.length+1][arr.length+1];
    //     // for(long i[] : dp) Arrays.fill(i,-1);
    //     // long val = help(arr,0,-1,dp);
    //     long val = tabularized(arr);
    //     System.out.println(val);
    // }

    // private static long tabularized(int[][] arr) {
    //     // TODO Auto-generated method stub
    //     long next[] = new long[arr.length + 1];
    //     for (int i = arr.length - 1; i >= 0; i--) {
    //         for (int j = -1; j < i; j++) {
    //             long notTake = next[j + 1];
    //             long take = 0;
    //             if (j == -1 || arr[j][1] < arr[i][0]) {
    //                 take = arr[i][2] + next[i + 1];
    //             }
    //             next[j + 1] = Math.max(take, notTake);
    //         }
    //     }
    //     return next[-1 + 1];
    // }

    // private static long help(int[][] arr, int index, int prev, long[][] dp) {
    //     // TODO Auto-generated method stub
    //     if (index == arr.length)
    //         return 0;
    //     if (dp[index][prev + 1] != -1)
    //         return dp[index][prev + 1];
    //     long notTake = help(arr, index + 1, prev, dp);
    //     long take = 0;
    //     if (prev == -1 || arr[prev][1] < arr[index][0]) {
    //         take = arr[index][2] + help(arr, index + 1, index, dp);
    //     }
    //     return dp[index][prev + 1] = Math.max(take, notTake);
    // }

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
