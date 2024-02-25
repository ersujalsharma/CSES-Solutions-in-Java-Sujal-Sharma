import java.util.*;
 
public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char c = ' ';
        int count = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(c==' ' || s.charAt(i)==c){
                count++;
                c = s.charAt(i);
                max = Math.max(max,count);
            }
            else{
                count = 1;
                c=s.charAt(i);
            }
        }
        System.out.println(max);
    }
}
