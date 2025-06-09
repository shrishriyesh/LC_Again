class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            // Pop all shorter people – they are visible
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }

            // If a taller person remains, they are also visible
            if (!stack.isEmpty()) {
                count++;
            }

            result[i] = count;
            stack.push(heights[i]);  // Push current person to stack
        }

        return result;
    }
}