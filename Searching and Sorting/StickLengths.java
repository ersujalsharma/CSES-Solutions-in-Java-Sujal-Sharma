import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StickLengths {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String var[] = bufferedReader.readLine().split(" ");
        String requisites[] = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(var[0]);
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(requisites[i]);
        }
        long ans = help(arr);
        System.out.println(ans);
    }

    private static long help(int[] arr) {
        // Median is the point which is the differences peak 
        // from median the left have and the right have equal differenes.
        Arrays.sort(arr);
        int median = arr[arr.length/2];
        long ans = 0;
        for(int i:arr){
            ans += Math.abs(i-median);
        }
        return ans;
    }
    
}
