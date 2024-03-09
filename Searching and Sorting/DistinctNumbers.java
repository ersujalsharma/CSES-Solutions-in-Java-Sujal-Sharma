import java.util.HashSet;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> hashset = new HashSet<>();
        for(int i:arr) hashset.add(i);
        System.out.println(hashset.size());
        scanner.close();
    }
}
