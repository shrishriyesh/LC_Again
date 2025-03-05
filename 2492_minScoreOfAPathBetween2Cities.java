import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Adjacency list representation of the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // Construct the graph
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        // Use BFS/DFS to find the minimum edge in the connected component containing node 1
        boolean[] visited = new boolean[n + 1];
        return dfs(graph, 1, visited);
    }

    private int dfs(Map<Integer, List<int[]>> graph, int node, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        int minScore = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int[] neighbor : graph.get(current)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                minScore = Math.min(minScore, edgeWeight);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
        return minScore;
    }
}
