//LC 1438 Longest Continuous Subarray with Absolute Diff Less Than or Equal to Limit

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // int left = 0, right = 0, maxLength = 0;
        // while (right < nums.length) {
        //     minHeap.offer(nums[right]);
        //     maxHeap.offer(nums[right]);
        //     while (maxHeap.peek() - minHeap.peek() > limit) {
        //         minHeap.remove(nums[left]);
        //         maxHeap.remove(nums[left]);
        //         left++;
        //     }
        //     maxLength = Math.max(maxLength, right - left + 1);
        //     right++;
        // }
        // return maxLength;
        Deque<Integer> minHeap = new LinkedList()<>();
        Deque<Integer> maxHeap = new LinkedList()<>();
        int left = 0, right = 0, maxLength = 0;
        while(right < nums.length) {
            while (!minHeap.isEmpty() && minHeap.peekLast() > nums[right]) {
                minHeap.removeLast();
            }
            minHeap.addLast(nums[right]);
            while (!maxHeap.isEmpty() && maxHeap.peekLast() < nums[right]) {
                maxHeap.removeLast();
            }
            maxHeap.addLast(nums[right]);
            while (maxHeap.peekFirst() - minHeap.peekFirst() > limit) {
                if (minHeap.peekFirst() == nums[left]) {
                    minHeap.removeFirst();
                }
                if (maxHeap.peekFirst() == nums[left]) {
                    maxHeap.removeFirst();
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}