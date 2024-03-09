import java.io.*;
import java.util.*;
public class Ferris_Wheel {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] in_var = bufferedReader.readLine().split(" ");
        String[] in_req_sizes = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(in_var[0]);
        int x = Integer.parseInt(in_var[1]);
        List<Integer> weights = new ArrayList<>();

        for (int i=0;i<n;i++)
            weights.add(Integer.parseInt(in_req_sizes[i]));

        Solver solver = new Solver();
        System.out.println(solver.solve(weights,n,x));
    }
}

class Solver{
    int solve(List<Integer> weights, int n,int x){
        Collections.sort(weights);
        int i=0,j=n-1;
        int count = 0;
        while(i<=j){
            if(weights.get(i)+weights.get(j)<=x){
                i++;
                j--;
            }
            else if(weights.get(i)+weights.get(j)>x){
                j--;
            }
            count++;
        }
        return count;
    }
}
