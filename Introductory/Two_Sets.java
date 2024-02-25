import java.util.*;
 
public class Two_Sets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        sum = t*(long)(t+1)/2;
        if((sum&1)!=0) sb.append("NO ");
        else{
            sum/=2;
            sb.append("YES\n");
            StringBuilder ans1 = new StringBuilder();
            int count1 = 0;
            StringBuilder ans2 = new StringBuilder();
            int count2 = 0;
            for(int i=t;i>=1;i--){
                if(i>sum){
                    ans2.append(i+" ");
                    count2++;
                }
                else{
                    ans1.append(i+" ");
                    count1++;
                    sum-=i;
                }
            }
            sb.append(count2+"\n");
            sb.append(ans2+"\n");
            sb.append(count1+"\n");
            sb.append(ans1);
            // sb.append(sum+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
