// package graph;

import java.util.Scanner;

public class Building_Roads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char arr[][] = new char[n][m];
        for(int i=0;i<n;i++){
            String str = scanner.next();
            arr[i] = str.toCharArray();
        }
        int val = help(arr);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(val);
    }

    private static int help(char[][] arr) {
        // TODO Auto-generated method stub
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]=='.'){
                    dfs(arr,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] arr, int i, int j) {
        // TODO Auto-generated method stub
        if(i>=arr.length || i<0 || j>=arr[0].length || j<0 || arr[i][j] == '#'){
            return;
        }
        arr[i][j] = '#';
        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
    }
    
}
