class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums)
        {
            if(k>0)
            {
                pq.add(num);
                k--;
                continue;
            }
            else
            {
                if(pq.peek()<num)
                {
                    pq.poll();
                    pq.add(num);
                }
                else
                continue;
            }
        }
        return pq.poll();
    }
}