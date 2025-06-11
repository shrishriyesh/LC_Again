class Solution {
    private int R, C;
    private final int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };

    public int minimumEffortPath(int[][] heights) {
        R = heights.length;
        C = heights[0].length;

        // effort[r][c] = the best (smallest) effort found so far to reach (r,c)
        int[][] effort = new int[R][C];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        /*  Min-heap ordered by current path effort.
            int[]{row, col, effortSoFar}  */
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], currEffort = cur[2];

            // If we already have a better path cached, skip.
            if (currEffort > effort[r][c]) continue;

            // Destination reached – the heap guarantees this is minimal.
            if (r == R - 1 && c == C - 1) return currEffort;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    int edgeCost = Math.abs(heights[r][c] - heights[nr][nc]);
                    int nextEffort = Math.max(currEffort, edgeCost);
                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        pq.offer(new int[]{nr, nc, nextEffort});
                    }
                }
            }
        }
        return 0;   // never reached on valid input
    }
}
