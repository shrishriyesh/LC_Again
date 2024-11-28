class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
        return nums;
        int res[]=new int[nums.length];
        if( 2 * k + 1 > nums.length)
        {
            for(int i=0;i<nums.length;i++)
            res[i]=-1;
            return res;
        }
        int x=0;
        int y=x+k;
        int z=y+k;
        long sum=0;
        for(int i=0;i<=z;i++)
        {
            sum+=nums[i];
            if(i<y)
            res[i]=-1;
        }
        while(z<nums.length)
        {
            res[y]=(int)(sum/(z+1-x));
            z++;
            if(z<nums.length)
            sum+=nums[z];
            else
            break;
            sum-=nums[x];
            x++;
            y++;
        }
        for(int i=y+1;i<z;i++)
        res[i]=-1;
        return res;
    }
}