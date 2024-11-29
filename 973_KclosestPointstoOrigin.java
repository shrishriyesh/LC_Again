class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //Priority Queue to store the position of point and distance from origin, sorted based on distance.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> findDistance(b) - findDistance(a));
        for(int i=0; i<points.length; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int result[][] = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }
        return result;
        
    }
    findDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}