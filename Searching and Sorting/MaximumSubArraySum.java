import java.io.*;

public class MaximumSubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in_var = bufferedReader.readLine().split(" ");
        String[] in_req_sizes = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(in_var[0]);
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(in_req_sizes[i]);
        }
        System.out.println(solve(n,arr));
    }
    static long solve(int n,int[] arr){
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum+(long)arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum<0) sum = 0;
        }
        return maxSum;
    }
}
