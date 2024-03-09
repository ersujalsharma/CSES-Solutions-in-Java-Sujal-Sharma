import java.io.*;
import java.util.*;
public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        String[] in_var = bufferedReader.readLine().split(" ");
        String[] in_req_sizes = bufferedReader.readLine().split(" ");
        String[] in_apt_sizes = bufferedReader.readLine().split(" ");
 
        int n = Integer.parseInt(in_var[0]);
        int m = Integer.parseInt(in_var[1]);
        int k = Integer.parseInt(in_var[2]);
 
        List<Integer> req_sizes = new ArrayList<>();
        List<Integer> apt_sizes = new ArrayList<>();
 
        for (int i=0;i<n;i++)
            req_sizes.add(Integer.parseInt(in_req_sizes[i]));
 
        for (int j=0;j<m;j++)
            apt_sizes.add(Integer.parseInt(in_apt_sizes[j]));
 
        Solver solver = new Solver();
        System.out.println(solver.solve(req_sizes,apt_sizes,n,m,k));
    }
}
 
class Solver{
    int solve(List<Integer> req_sizes, List<Integer> apt_sizes, int n, int m, int k){
        int count=0;
        int range;
 
        Collections.sort(req_sizes);
        Collections.sort(apt_sizes);
        int i=0,j=0;
        int a,b;
        while(i<n && j<m){
            a=apt_sizes.get(j);
            b=req_sizes.get(i);
            range=range(a,b,k);
            if (range==0){
                i++;
                j++;
                count++;
            }else if(range==-1){
                i++;
            }else j++;
        }
        return count;
    }
    int range(int a, int b, int k){
        if (a>=b-k){
            if (a<=b+k)
                return 0;
            else
                return -1;
        }else return 1;
    }
}
