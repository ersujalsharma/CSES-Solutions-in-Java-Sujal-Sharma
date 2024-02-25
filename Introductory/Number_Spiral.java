import java.util.*;
 
public class Number_Spiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            long ans = 0;
            if(y<x){
                if((x&1)==0){ 
                    ans = (x-1)*(long)(x-1) +1;
                    ans = ans + (y-1);
                }
                else{
                    ans = x*(long)x;
                    ans = ans - (y-1);
                }
            }
            else{
                if((y&1)!=0){ ans = (y-1)*(long)(y-1) +1;
                    ans = ans + (x-1);
 
                }
                else{
                    ans = y*(long)y;
                    ans = ans - (x-1);
                }
            } 
            sb.append(ans+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
