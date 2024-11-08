import java.io.*;
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i<intervals.length;i++){
            int[] upper = stack.peek();
            if(intervals[i][0] <= upper[1]) {
                int[] newInterval = new int[]{upper[0], Math.max(intervals[i][1], upper[1])};
                stack.pop();
                stack.push(newInterval);
            } else {
                stack.push(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return stack.toArray(new int[stack.size()][]);
    }
}