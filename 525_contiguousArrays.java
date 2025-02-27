class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int res=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count+=-1;
            }
            else
            {
                count+=1;
            }
            if(map.containsKey(count))
            {
                int lI=map.get(count);
                res=Math.max(i-lI,res);
            }
            else
            map.put(count,i);
        }
        return res;
    }
}