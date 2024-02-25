import java.util.*;
 
public class Bit_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        long ans = 1l;
        while(t-->0){
            ans = (ans << 1) % 1000000007; 
        }
        sb.append(ans);
        // sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
