import java.util.*;
 
public class Chessboard_and_Queens {
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 8;
        char c[][] = new char[n][n];
        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            for(int j=0;j<str.length();j++){
                c[i][j] = str.charAt(j);
            }
        }
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[n];
        boolean ldia[] = new boolean[2*n-1]; // i+j
        boolean rdia[] = new boolean[2*n-1]; // i-j+n-1;
        int ans =  help(c,0,row,col,ldia,rdia);
        System.out.println(ans);
    }
    private static int help(char[][] c, int i, boolean[] row, boolean[] col, boolean[] ldia, boolean[] rdia) {
        // TODO Auto-generated method stub
        if(i==c.length){
            return 1;
        }
        int count = 0;
        for(int j=0;j<c.length;j++){
            if(!col[j] && !ldia[i+j] && !rdia[i-j+c.length-1] && c[i][j]=='.'){
                c[i][j] = '*';
                col[j] = true;
                ldia[i+j] = true;
                rdia[i-j+c.length-1] = true;
                count += help(c,i+1,row,col,ldia,rdia);
                c[i][j] = '.';
                col[j] = false;
                ldia[i+j] = false;
                rdia[i-j+c.length-1] = false;
            }
        }
        return count;    
    }
 
}
