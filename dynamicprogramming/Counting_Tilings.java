import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Counting_Tilings {
    static long[][] dp = new long[1050][2050]; // dp[i][mask] stores the number of ways to fill the grid starting from column i with the mask representing the current state of filled cells

    static final int MOD = (int)1e9 + 7;

    // Function to generate the next possible mask based on the current mask and position
    static void generateNextMask(int n, int curr_mask, int new_mask, int j, ArrayList<Integer> nextMask) {
        if (j == n) {
            nextMask.add(new_mask);
            return;
        }
        // If there's enough space and cells are empty, place a 2x1 tile
        if (j + 1 < n && ((1 << j & curr_mask) == 0) && ((1 << (j + 1) & curr_mask) == 0)) {
            generateNextMask(n, curr_mask, new_mask, j + 2, nextMask);
        }
        // Place a 1x2 tile if the cell is empty
        if ((1 << j & curr_mask) == 0) {
            generateNextMask(n, curr_mask, new_mask + (1 << j), j + 1, nextMask);
        }
        // Move to the next cell if the current cell is already filled
        if ((1 << j & curr_mask) != 0) {
            generateNextMask(n, curr_mask, new_mask, j + 1, nextMask);
        }
    }

    // Recursive function to compute the number of ways to fill the grid
    static long countWays(int n, int m, int i, int mask) {
        // Base case: reached the end of the grid
        if (i == m) {
            // If the entire grid is filled, return 1, otherwise return 0
            if (mask == 0)
                return 1;
            else
                return 0;
        }

        // If the result for the current state is already computed, return it
        if (dp[i][mask] != -1)
            return dp[i][mask];

        // Generate next possible masks for the current column
        ArrayList<Integer> nextMask = new ArrayList<>();
        generateNextMask(n, mask, 0, 0, nextMask);

        // Initialize the answer for the current state
        long ans = 0;

        // Iterate over all possible next masks and recursively compute the answer
        for (int x : nextMask) {
            ans = (ans % MOD + countWays(n, m, i + 1, x) % MOD) % MOD;
        }

        // Memoize the result and return it
        dp[i][mask] = ans;
        return dp[i][mask];
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        // Initialize dp array with -1
        for (long[] row : dp)
            Arrays.fill(row, -1);

        // Compute and print the number of ways to fill the grid
        System.out.println(countWays(n, m, 0, 0));
    }
}
