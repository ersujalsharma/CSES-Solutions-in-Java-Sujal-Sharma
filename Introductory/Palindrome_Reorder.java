import java.util.*;
 
public class Palindrome_Reorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder sb = new StringBuilder();
 
        int arr[] = new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'A']++;
        }
        int count = 0;
        for(int i:arr){
            if(i%2==1) count++;
            if(count==2) break;
        }
        if(count>1){
            sb.append("NO SOLUTION");
        }
        else{
            char c = ' ';
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i=0;i<26;i++){
                if(arr[i]>0){
                    for(int j=0;j<(arr[i])/2;j++){
                        sb1.append((char)(i+'A'));
                        sb2.append((char)(i+'A'));
                    }
                    if(arr[i]%2==1) c = (char)('A'+i); 
                }
            }
            sb.append(sb1.append(c!=' '?c:""));
            sb.append(sb2.reverse());
        }
        // sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
