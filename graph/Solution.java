import java.io.*;
import java.util.*;

public class Solution {
    // static class Node{
    //     int row,col;
    //     int dis;
    //     public Node(int row,int col,int dis){
    //         this.row = row;
    //         this.col = col;
    //         this.dis = dis;
    //     }
    // }
    // static int row[] = {-1,0,+1,0};
    // static int col[] = {0,-1,0,+1};
    // public static void main(String[] args) {
    //     FastIO scanner = new FastIO();
    //     int n = scanner.nextInt();
    //     int m = scanner.nextInt();
    //     char[][] arr = new char[n][m];
    //     int a_x = -1;
    //     int a_y = -1;
    //     int b_x = -1;
    //     int b_y = -1;
    //     for(int i=0;i<n;i++){
    //         String str = scanner.next();
    //         for(int j=0;j<m;j++){
    //             arr[i][j] = str.charAt(j);
    //             if(str.charAt(j)=='A'){
    //                 a_x = i;
    //                 a_y = j;
    //             }
    //             if(str.charAt(j)=='B'){
    //                 b_x = i;
    //                 b_y = j;
    //             }
    //         }
    //     }
    //     int size = 0;
    //     Queue<Node> q = new ArrayDeque<>();
    //     q.add(new Node(a_x, a_y, 0));
    //     while(!q.isEmpty()){
    //         Node poppedNode = q.poll();
    //         int poppedRow = poppedNode.row;
    //         int poppedCol = poppedNode.col;
    //         int dis = poppedNode.dis;
    //         if(poppedRow == b_x && poppedCol == b_y) {
    //             size = dis;
    //             break;
    //         }
    //         for(int i=0;i<4;i++){
    //             if(check(arr,poppedRow+row[i],poppedCol+col[i])){
    //                 arr[poppedRow+row[i]][poppedCol+col[i]] = '#';
    //                 if(i==0){
    //                     newPath = poppedPath+'U';                        
    //                 }
    //                 else if(i==1){
    //                     newPath = poppedPath+'L';                     
    //                 }
    //                 else if(i==2){
    //                     newPath = poppedPath+'D';
    //                 }
    //                 else{
    //                     newPath = poppedPath+'R';
    //                 }
    //                 q.add(new Node(poppedRow+row[i], poppedCol+col[i], newPath));
    //             }
    //         }
    //     }
    //     if(ans.equals("")){
    //         System.out.println("NO");
    //     }
    //     else{
    //         System.out.println("YES\n"+ans.length()+"\n"+ans);
    //     }
    // }
    // private static boolean check(char[][] arr, int i, int j) {
    //     // TODO Auto-generated method stub
    //     if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]=='#' || arr[i][j] == 'A') return false;
    //     return true;
    // }
    //   static class FastIO extends PrintWriter {
    //     private InputStream stream;
    //     private byte[] buf = new byte[1 << 16];
    //     private int curChar, numChars;
    
    //     // standard input
    //     public FastIO() { this(System.in, System.out); }
    //     public FastIO(InputStream i, OutputStream o) {
    //         super(o);
    //         stream = i;
    //     }
    //     // file input
    //     public FastIO(String i, String o) throws IOException {
    //         super(new FileWriter(o));
    //         stream = new FileInputStream(i);
    //     }
    
    //     // throws InputMismatchException() if previously detected end of file
    //     private int nextByte() {
    //         if (numChars == -1) throw new InputMismatchException();
    //         if (curChar >= numChars) {
    //             curChar = 0;
    //             try {
    //                 numChars = stream.read(buf);
    //             } catch (IOException e) { throw new InputMismatchException(); }
    //             if (numChars == -1) return -1;  // end of file
    //         }
    //         return buf[curChar++];
    //     }
    
    //     // to read in entire lines, replace c <= ' '
    //     // with a function that checks whether c is a line break
    //     public String next() {
    //         int c;
    //         do { c = nextByte(); } while (c <= ' ');
    //         StringBuilder res = new StringBuilder();
    //         do {
    //             res.appendCodePoint(c);
    //             c = nextByte();
    //         } while (c > ' ');
    //         return res.toString();
    //     }
    //     public int nextInt() {  // nextLong() would be implemented similarly
    //         int c;
    //         do { c = nextByte(); } while (c <= ' ');
    //         int sgn = 1;
    //         if (c == '-') {
    //             sgn = -1;
    //             c = nextByte();
    //         }
    //         int res = 0;
    //         do {
    //             if (c < '0' || c > '9') throw new InputMismatchException();
    //             res = 10 * res + c - '0';
    //             c = nextByte();
    //         } while (c > ' ');
    //         return res * sgn;
    //     }
    //     public double nextDouble() { return Double.parseDouble(next()); }
    // }
    public static int[] dX = {-1, 0, 0, 1};
	public static int[] dY = {0, -1, 1, 0};
	public static String dirs = "ULRD";

	// Coordinates for points A and B.
	public static point A = new point(-1, -1);
	public static point B = new point(-1, -1);

	public static void main(String[] args) throws IOException {
		BufferedReader br =
		    new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] blocked = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] prevMove = new int[N][M];

		// Read in the grid.
		for (int i = 0; i < N; i++) {
			char[] S = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (S[j] == '#') {
					blocked[i][j] = true;
				} else {
					blocked[i][j] = false;
					if (S[j] == 'A') { A = new point(i, j); }

					if (S[j] == 'B') { B = new point(i, j); }
				}
			}
		}
		Queue<point> q = new LinkedList<>();
		q.add(A);

		// BFS starting from point A.
		while (!q.isEmpty()) {
			point cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				point next = new point(cur.x + dX[dir], cur.y + dY[dir]);
				// Check if the next point is visit-able.
				if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= M) {
					continue;
				}
				if (blocked[next.x][next.y]) { continue; }
				if (visited[next.x][next.y]) { continue; }
				visited[next.x][next.y] = true;
				prevMove[next.x][next.y] = dir;
				q.add(next);
			}
		}

		if (visited[B.x][B.y]) {
			pw.println("YES");
			ArrayList<Integer> moves = new ArrayList<>();

			// Now we can go backwards from B to find all the moves we made.
			while ((A.x != B.x) || (A.y != B.y)) {
				int prevDir = prevMove[B.x][B.y];
				moves.add(prevDir);

				B.x = B.x - dX[prevDir];
				B.y = B.y - dY[prevDir];
			}
			Collections.reverse(moves);

			pw.println(moves.size());
			for (int i : moves) { pw.print(dirs.charAt(i)); }

		} else {
			// We cannot reach point B.
			pw.println("NO");
		}
		pw.close();
	}

	public static class point {
		public int x, y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
