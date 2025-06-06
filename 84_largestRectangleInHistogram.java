class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n= heights.length;
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    int top = stack.pop();
                    int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, area);
                    i--; // Re-evaluate the current index
                }
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}