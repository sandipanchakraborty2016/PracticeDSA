package DFS;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category[]=DFS&category[]=Backtracking&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions
public class DetectCycleUndirected {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V <= 0) {
            return false;
        }
        if (adj.isEmpty()) {
            return false;
        }
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (traverse(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean traverse(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                if (traverse(child, node, adj, visited)) {
                    return true;
                }
            } else if (parent != node) {
                return true;
            }
        }
        return false;
    }


}
