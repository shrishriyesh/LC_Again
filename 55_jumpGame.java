class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        int dist=nums[i];
        while(i<=dist)
        {
            int maxdist=0;
            int j=i;
            for(j=i;j<=dist&&j<nums.length;j++)
            {
                maxdist=Math.max(maxdist,j+nums[j]);
            }
            dist=maxdist;
            i=j;
            if(j>=nums.length)
            return true;
        }
        return false;
    }
}


// Time Complexity : O(n)
//New Approach in one loop

class Solution {
    public boolean canJump(int[] nums) {
        int dist = nums[0]; // max reachable distance
        for (int i = 0; i <= dist; i++) {
            dist = Math.max(dist, i + nums[i]);
            if (dist >= nums.length - 1) return true;
        }
        return false;
    }
}