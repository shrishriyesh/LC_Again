class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //DFS Based approach
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dfs(i, graph, color)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int node, int[][] graph, int[] color)
    {
        if(color[node] > 0){
            return color[node] == 2;
        }
        color[node] = 1;
        if(graph[node].length > 0){
            for(int next : graph[node]){
                if(color[next] == 2){
                    continue;
                }
                if(color[next] == 1 || !dfs(next, graph, color)){
                    return false;
                }
            }
        }
        color[node] = 2;
        return true;
    }
}