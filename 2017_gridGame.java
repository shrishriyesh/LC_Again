class Solution {
    public long gridGame(int[][] grid) {
    int n = grid[0].length;
    
    long[] top = new long[n];
    long[] bottom = new long[n];
    
    // Build prefix sums L->R for top row
    top[0] = grid[0][0];
    for (int i = 1; i < n; i++) {
        top[i] = top[i-1] + grid[0][i];
    }
    
    // Build prefix sums L->R for bottom row
    bottom[0] = grid[1][0];
    for (int i = 1; i < n; i++) {
        bottom[i] = bottom[i-1] + grid[1][i];
    }
    
    long ans = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        // Sum of top row that Robot 2 can take if Robot 1 drops down at i
        long topSum = top[n - 1] - top[i];
        // Sum of bottom row that Robot 2 can take
        long bottomSum = (i == 0) ? 0 : bottom[i - 1];
        long secondRobot = Math.max(topSum, bottomSum);
        ans = Math.min(ans, secondRobot);
    }
    return ans;
}

}
