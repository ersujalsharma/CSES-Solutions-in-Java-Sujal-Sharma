import java.util.*;
 
public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==1) System.out.println(1);
        else if(n<=3) System.out.println("NO SOLUTION");
        else{
            StringBuilder output = new StringBuilder();
            for (int i = 2; i <= n; i += 2) {
                output.append(i).append(" ");
            }
            for (int i = 1; i <= n; i += 2) {
                output.append(i).append(" ");
            }
            System.out.println(output);
        }
    }
}
