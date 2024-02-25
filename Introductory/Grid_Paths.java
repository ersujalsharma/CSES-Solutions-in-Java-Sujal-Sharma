import java.util.Scanner;
 
public class Grid_Paths {
	static boolean[][] onPath = new boolean[9][9];
	// added border to all four sides so a 7x7 becomes a 9x9
	static int[] dr = {-1, 0, 1, 0};  // transitions to up, right, down, left
	static int[] dc = {0, 1, 0, -1};  // for row and column, respectively
	static int[] p = new int[48];     // all possible paths have length 48
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
 
		// convert path to ints
		for (int i = 0; i < p.length; i++) {
			char cur = line.charAt(i);
 
			if (cur == 'U') p[i] = 0;
			else if (cur == 'R') p[i] = 1;
			else if (cur == 'D') p[i] = 2;
			else if (cur == 'L') p[i] = 3;
			else p[i] = 4;  // cur == '?'
		}
 
		// set borders of grid
		for (int i = 0; i < 9; i++) {
			onPath[0][i] = true;
			onPath[8][i] = true;
			onPath[i][0] = true;
			onPath[i][8] = true;
		}
 
		int ans = tryPath(0, 1, 1);
		System.out.println(ans);
	}
 
	public static int tryPath(int pathIdx, int curR, int curC) {
		// Optimization 3
		if ((onPath[curR][curC - 1] && onPath[curR][curC + 1]) &&
		    (!onPath[curR - 1][curC] && !onPath[curR + 1][curC]))
			return 0;
		if ((onPath[curR - 1][curC] && onPath[curR + 1][curC]) &&
		    (!onPath[curR][curC - 1] && !onPath[curR][curC + 1]))
			return 0;
 
		// Optimization 1
		if (curR == 7 && curC == 1) {           // reached endpoint
			if (pathIdx == p.length) return 1;  // visited every cell -> valid!
			return 0;  // didn't visit every cell (path length is too short)
		}
		// visited all cells, but didn't end up in the correct locaiton
		if (pathIdx == p.length) return 0;
 
		int ret = 0;  // cumulative count for this "starting position"
		onPath[curR][curC] = true;
 
		// turn already determined, try going in that direction
		if (p[pathIdx] < 4) {
			int nxtR = curR + dr[p[pathIdx]];
			int nxtC = curC + dc[p[pathIdx]];
			if (!onPath[nxtR][nxtC]) {
				ret += tryPath(pathIdx + 1, nxtR, nxtC);
			}
		}
		// now search for dead ends (Optimization 4)
		else if ((curC > 2) && onPath[curR][curC - 2] &&
		         (onPath[curR - 1][curC - 1] || onPath[curR + 1][curC - 1]) &&
		         (!onPath[curR][curC - 1])) {
			// potential dead end on the left:
			int nxtR = curR;
			int nxtC = curC - 1;
			ret += tryPath(pathIdx + 1, nxtR, nxtC);
		} else if ((curC < 6) && onPath[curR][curC + 2] &&
		           (onPath[curR - 1][curC + 1] || onPath[curR + 1][curC + 1]) &&
		           (!onPath[curR][curC + 1])) {
			// potential dead end on the right:
			int nxtR = curR;
			int nxtC = curC + 1;
			ret += tryPath(pathIdx + 1, nxtR, nxtC);
		} else if ((curR > 2) && onPath[curR - 2][curC] &&
		           onPath[curR - 1][curC - 1] && (!onPath[curR - 1][curC])) {
			// potential dead end upwards
			// note: I didn't include all possible scenarios because
			// it wasn't necessary in order for the program to run in time
			int nxtR = curR - 1;
			int nxtC = curC;
			ret += tryPath(pathIdx + 1, nxtR, nxtC);
		}
		// iterate through all four possible turns
		else {
			for (int i = 0; i < 4; i++) {
				int nxtR = curR + dr[i];
				int nxtC = curC + dc[i];
				if (onPath[nxtR][nxtC]) continue;
				ret += tryPath(pathIdx + 1, nxtR, nxtC);
			}
		}
 
		// reset and return
		onPath[curR][curC] = false;
		return ret;
	}
}
