import java.util.*;
 
public class Coin_Piles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while(n-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sb.append(((a + b) % 3 == 0 && (Math.min(a, b) * 2 >= Math.max(a, b))) ? "YES\n" : "NO\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
