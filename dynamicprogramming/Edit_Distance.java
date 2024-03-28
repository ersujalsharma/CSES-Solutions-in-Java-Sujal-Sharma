import java.util.Arrays;
import java.util.Scanner;

public class Edit_Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String other = scanner.next();
        int dp[][] = new int[str.length()+1][other.length()+1];
        for(int i[] : dp) Arrays.fill(i,-1);
        // int val = memoized(str,str.length(),other,other.length(),dp);
        int val = tabularized(str,other);
        System.out.println(val);
    }


    private static int tabularized(String str, String other) {
        // TODO Auto-generated method stub
        int length1 = str.length();
        int length2 = other.length();
        int dp[][] = new int[str.length()+1][other.length()+1];    
        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                int add = 0;
                int replace = 0;
                int remove = 0;
                int common = 0;
                int min = Integer.MAX_VALUE;
                if(str.charAt(i-1) != other.charAt(j-1)){
                    // add n,m -> n+1,m -> n,m-1
                    add = 1 + dp[i][j-1];
                    min = Math.min(add,min);
                    remove = 1 + dp[i-1][j];
                    min = Math.min(remove,min);
                    replace = 1 + dp[i-1][j-1];
                    min = Math.min(replace,min);
                }
                else{
                    common = dp[i-1][j-1];
                    min = Math.min(common,min);
                }

                dp[i][j] = min;
            }
        }
        return dp[str.length()][other.length()];
    }


    private static int memoized(String str, int length1, String other, int length2, int[][] dp) {
        // TODO Auto-generated method stub
        if(length1==0 || length2==0){
            return Math.max(length1,length2);
        }
        if(dp[length1][length2]!=-1) return dp[length1][length2];
        int add = 0;
        int replace = 0;
        int remove = 0;
        int common = 0;
        int min = Integer.MAX_VALUE;
        if(str.charAt(length1-1) != other.charAt(length2-1)){
            // add n,m -> n+1,m -> n,m-1
            add = 1 + memoized(str, length1, other, length2-1,dp);
            min = Math.min(add,min);
            remove = 1 + memoized(str, length1-1, other, length2,dp);
            min = Math.min(remove,min);
            replace = 1 + memoized(str, length1-1, other, length2-1,dp);
            min = Math.min(replace,min);
        }
        else{
            common = memoized(str, length1-1, other, length2-1,dp);
            min = Math.min(common,min);
        }

        return dp[length1][length2] = min;
    }
    
}
