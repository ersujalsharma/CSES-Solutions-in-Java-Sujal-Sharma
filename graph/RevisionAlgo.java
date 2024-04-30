package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RevisionAlgo {
    public static void main(String[] args) {
        ArrayList<Integer> graph[] = new ArrayList[7];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[1].add(0);
        graph[2].add(0);
        graph[2].add(4);
        graph[3].add(1);
        graph[3].add(5);
        graph[4].add(2);
        graph[4].add(5);
        graph[5].add(3);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(5);
        boolean visited[] = new boolean[7];
        // dfs(0,visited,graph);
        bfs(graph,visited);
    }

    private static void bfs(ArrayList<Integer>[] graph, boolean[] visited) {
        // TODO Auto-generated method stub
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int val = q.poll();
            System.out.print(val+" ");
            for(int neighbour : graph[val]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    private static void dfs(int i, boolean[] visited, ArrayList<Integer>[] graph) {
        // TODO Auto-generated method stub
        if(i>=visited.length) return;
        System.out.print(i+" ");
        visited[i] = true;
        for(int neighbour : graph[i]){
            if(!visited[neighbour]){
                dfs(neighbour, visited, graph);
            }
        }
    }
}
