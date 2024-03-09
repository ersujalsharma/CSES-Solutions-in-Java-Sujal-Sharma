import java.io.*;
import java.util.*;

public class Restaurant_Customers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in_var = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(in_var[0]);
        int arr[] = new int[n];
        int dep[] = new int[n];
        for(int i=0;i<n;i++){
            String[] in_req_sizes = bufferedReader.readLine().split(" ");
            arr[i] = Integer.parseInt(in_req_sizes[0]);
            dep[i] = Integer.parseInt(in_req_sizes[1]);
        }
        System.out.println(solve(arr,dep));
    }
    static long solve(int[] arr,int dep[]){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;
        int j=0;
        int max = 0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<dep[j]){
                max = Math.max(i-j+1,max);
                i++;
            }
            else{
                j++;
            }
        }
        return max;
    }
}
