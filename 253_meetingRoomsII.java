class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // // sort the intervals by start time
        // Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        // // create a min heap to store the end time of each meeting
        // priorityQueue<Integer> pq = new priorityQueue<>();
        // // counter to store the number of rooms
        // int c=0;
        // // iterate through the intervals
        // for(int[] interval : intervals){
        //     // if the heap is not empty and the start time of the current interval is greater than the end time of the meeting at the top of the heap, then remove the meeting from the heap
        //     if(!pq.isEmpty() && pq.peek() <= interval[0]){
        //         pq.poll();
        //     }

        //     pq.add(interval[1]);
        // }
        // return pq.size();
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            start= intervals[i][0];
            end = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int count=0;
        int max=0;
        while(i<start.length)
        {
            if(start[i]<end[j])
            {
                count++;
                i++;
            }
            else
            {
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}