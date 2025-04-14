class Solution {
    
    // Idea: group diagonals that have same length and same center
    
    public double minAreaFreeRect(int[][] points) {
        int N = points.length;
        if (N < 4) return 0.0;
        
        Map<String,List<int[]>> map = new HashMap<>();  // int[]{point1_idx, point2_idx} of a diagonal
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long sqDist = getDistSquare(points[i], points[j]);
                long centerX = points[i][0] + points[j][0];   // this is actually twice the x-value
                long centerY = points[i][1] + points[j][1];   // this is actually twice the y-value
                String key = sqDist + "_" + centerX + "_" + centerY;
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<int[]>());
                map.get(key).add(new int[]{i,j});
            }
        }
        
        double res = Double.MAX_VALUE;
        for (List<int[]> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    int[] p1 = points[list.get(i)[0]];
                    int[] p2 = points[list.get(j)[0]];
                    int[] p3 = points[list.get(j)[1]];
                    double area = Math.sqrt(getDistSquare(p1,p2)) * Math.sqrt(getDistSquare(p1,p3));
                    res = Math.min(res, area);
                }
            }
        }
        
        return res < Double.MAX_VALUE ? res : 0.0;
        
    }
    
    private long getDistSquare(int[] p1, int[] p2) {
        long xDelta = p1[0] - p2[0];
        long yDelta = p1[1] - p2[1];
        return xDelta * xDelta + yDelta * yDelta;
    }
}