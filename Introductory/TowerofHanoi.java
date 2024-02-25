import java.util.*;
 
public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        sb.append((int)Math.pow(2, n)-1+"\n");
        help(n,1,2,3,sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public static void help(int n,int first,int second,int third,StringBuilder sb){
        if(n==1){
            sb.append(first+" "+third+"\n");
            return; 
        }
        help(n-1, first, third, second, sb);
        sb.append(first+" "+third+"\n");
        help(n-1, second, first, third, sb);
    }
}
