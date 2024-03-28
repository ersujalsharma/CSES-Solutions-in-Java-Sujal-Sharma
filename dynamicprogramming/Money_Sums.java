import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Money_Sums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int sum =0 ;
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        TreeSet<Integer> treeSet = new TreeSet();
        int dp[][] = new int[arr.length][sum+1];
        memoized(arr,arr.length-1,0,treeSet,dp);
        StringBuilder sb = new StringBuilder();
        sb.append(treeSet.size()+"\n");
        for(int i : treeSet){
            sb.append(i+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    private static void memoized(int[] arr, int i,int sum,TreeSet<Integer> treeSet,int dp[][]) {
        // TODO Auto-generated method stub
        if(i==-1){
            if(sum!=0)
                treeSet.add(sum);
            return;
        }    
        if(dp[i][sum] == 1) return;
        memoized(arr, i-1, sum+arr[i], treeSet,dp);
        memoized(arr, i-1, sum, treeSet,dp);
        dp[i][sum] = 1;
    }
}
