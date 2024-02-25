import java.util.*;
 
public class Gray_Code {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for(int i=0;i<n;i++){
            int size = list.size();
            for(int j=size-1;j>=0;j--){
                list.add(list.get(j));
            }
            size *=2;
            for(int j=0;j<size;j++){
                if(j<list.size()/2){
                    list.set(j,list.get(j)+"0");
                }
                else{
                    list.set(j,list.get(j)+"1");
                }
            }
        }
        for(String s : list){
            sb.append(s+"\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
