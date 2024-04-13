import java.util.Arrays;
import java.util.Scanner;

public class Counting_Towers {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int max = 0;
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
            max = Math.max(arr[i],max);
        }
        long dp[] = new long[max+1];
        dp[1] = 2;
        dp[2] = 8;
        for(int i=3;i<=max;i++){
            dp[i] = ((6l*dp[i-1] - 7l*dp[i-2])%MOD+MOD)%MOD;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(dp[arr[i]]+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
