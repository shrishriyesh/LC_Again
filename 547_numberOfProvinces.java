class Solution {
    public int findCircleNum(int[][] isConnected) {
        int visited[] = new int[isConnected.length];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<isConnected.length;i++)
       {
        if(visited[i] == 1) continue;
        q.add(i);
        while(!q.isEmpty()){
            int city = q.poll();
            visited[city] = 1;
            for(int i1 = 0; i1 < isConnected.length; i1++){
                if(isConnected[city][i1] == 1 && visited[i1] == 0){
                    q.add(i1);
                }
            }
        }
        count++;
       }
        
        return count;
    }
}


//// Approach 2: DFS

// public int findCircleNum(int[][] isConnected) {
//     int n = isConnected.length;
//     boolean[] visited = new boolean[n];
//     int provinces = 0;
    
//     for (int i = 0; i < n; i++) {
//         if (!visited[i]) { // Only start a DFS if the node hasn't been visited
//             dfs(isConnected, visited, i);
//             provinces++;
//         }
//     }
    
//     return provinces;
// }

// private void dfs(int[][] isConnected, boolean[] visited, int city) {
//     visited[city] = true;
//     for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
//         if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
//             dfs(isConnected, visited, neighbor);
//         }
//     }
// }
// }
