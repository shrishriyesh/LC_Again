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