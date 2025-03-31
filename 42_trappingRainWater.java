class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while(l<r)
        {
            if(height[l]<height[r])
            {
                if(leftMax <= height[l])
                {
                    leftMax = height[l];
                }
                else
                {
                    water += leftMax - height[l];
                }
                l++;
            }
            else
            {
                if(rightMax <= height[r])
                {
                    rightMax = height[r];
                }
                else
                {
                    water += rightMax - height[r];
                }
                r--;
            }
        }
        return water;
    }
}