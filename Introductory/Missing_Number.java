import java.util.*;
 
public class Missing_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n-1;i++){
            arr[i] = scanner.nextInt();
        }
        int xor = 0;
        for(int i=0;i<n;i++){
            if(i<n-1)
                xor^=arr[i];
            xor ^=i+1;
        }
        System.out.println(xor);
    }
