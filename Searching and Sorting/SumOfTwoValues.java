import java.io.*;
import java.util.*;

public class SumOfTwoValues {
    static class Pair{
        int value;
        int index;
        public Pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in_var = bufferedReader.readLine().split(" ");
        String[] in_req_sizes = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(in_var[0]);
        int x = Integer.parseInt(in_var[1]);

        List<Pair> values = new ArrayList<>();
        for (int i=0;i<n;i++)
            values.add(new Pair(Integer.parseInt(in_req_sizes[i]),i+1));
        
        System.out.println(solve(values,n,x));
    }
    static String solve(List<Pair> values, int n,int x){
        Collections.sort(values,(a,b)->a.value-b.value);
        int i=0,j=n-1;
        while(i<j){
            if((long)values.get(i).value+(long)values.get(j).value==x){
                return values.get(i).index+" "+values.get(j).index;
            }
            else if((long)values.get(i).value+(long)values.get(j).value<x){
                i++;
            }
            else{
                j--;
            }
        }
        return "IMPOSSIBLE";
    }
}
