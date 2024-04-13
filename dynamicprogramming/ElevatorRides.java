import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ElevatorRides {
    static class Pair{
        int moves;
        int weight;
        public Pair(int moves,int weight){
            this.moves = moves;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        Pair dp[] = new Pair[2000010];
        dp[0] = new Pair(0,target);
        for(int i=1;i<=(1<<n)-1;i++){
            dp[i] = new Pair(n,target);
            for(int bit = 0;bit<=n-1;bit++){
                if(((i>>bit)&1)!=0){
                    int rem = i ^ (1<<bit);
                    if(target-dp[rem].weight>=arr[bit]){
                        dp[i].moves = Math.min(dp[i].moves, dp[rem].moves);
                        dp[i].weight = Math.min(dp[i].weight, dp[rem].weight + arr[bit]);
                    }
                    else{
                        dp[i].moves = Math.min(dp[i].moves, dp[rem].moves + 1);
                        dp[i].weight = Math.min(dp[i].weight, arr[bit]);
                    }
                }
            }
        }
        System.out.println(dp[(int) (1<<n)-1].moves);
    }
}   
