class Solution {
    public double separateSquares(int[][] squares) {
      double low = Double.MAX_VALUE, high = Double.MIN_VALUE;
        for (int[] square : squares) {
            int bottomY = square[1];
            int side = square[2];
            low = Math.min(low, bottomY);
            high = Math.max(high, bottomY + side);
        }

        // Step 2: Binary search
        while (high - low > 1e-6) {  // Precision requirement
            double mid = (low + high) / 2;
            if (isLowerHalfLarger(squares, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    private boolean isLowerHalfLarger(int[][] squares, double midY) {
        double lowerArea = 0.0, upperArea = 0.0;

        for (int[] square : squares) {
            double bottomY = square[1];
            double side = square[2];
            double topY = bottomY + side;

            if (bottomY >= midY) {
                // Entire square is above the line
                upperArea += side * side;
            } else if (topY <= midY) {
                // Entire square is below the line
                lowerArea += side * side;
            } else {
                // The line intersects the square
                double below = midY - bottomY;
                double above = topY - midY;
                lowerArea += below * side;
                upperArea += above * side;
            }
        }

        return lowerArea >= upperArea;
    }
    
}