import java.util.*;
 
public class Creating_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        TreeSet<String> ts = new TreeSet<>();
        help(str.toCharArray(),0,ts);
        StringBuilder sb = new StringBuilder();
        sb.append(ts.size()+"\n");
        for(String s : ts){
            sb.append(s+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public static void help(char str[],int index,TreeSet<String> ts){
        if(index == str.length){
            ts.add(new String(str));
            return;
        }
        for(int i=index;i<str.length;i++){
            if(i==index) help(str,index+1,ts);
            else if(str[i]!=str[index]){
                char temp = str[i];
                str[i] = str[index];
                str[index] = temp;
                help(str,index+1,ts);
                temp = str[i];
                str[i] = str[index];
                str[index] = temp;
            }
        }
    }
}
