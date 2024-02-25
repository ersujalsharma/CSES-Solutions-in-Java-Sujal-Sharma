import java.util.*;
 
public class Trailing_Zeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        long ans = 0,current = 5;
        while(current<=n){
            ans += n/current;
            current *= 5;
        }
        sb.append(ans+" ");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
