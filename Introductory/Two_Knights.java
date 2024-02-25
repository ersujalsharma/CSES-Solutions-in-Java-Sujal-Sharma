import java.util.*;
 
public class Two_Knights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(0+"\n");
        for(int i=2;i<=t;i++){
            sb.append((i*i)*(long)(i*i-1)/2 - 4*(i-2)*(long)(i-1));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
