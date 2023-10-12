package DFS;

import java.util.ArrayList;

public class DetectCycleDirected {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (traverse(i, visited, adj, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean traverse(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                if (traverse(child, visited, adj, recStack)) {
                    return true;
                }
            } else if (recStack[child]) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }


}
