import java.util.*;
 
public class Weird_Algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextInt();
        while(t>1){
            System.out.print(t+" ");
            if((t&1)!=0) {
                t = t*3+1;
            }
            else{
                t>>=1;
            }
        }
        System.out.print(1);
    }
}