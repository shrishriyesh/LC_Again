class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int sub=target-nums[i];
            if(hm.get(sub)!=null)
            {
                int arr[]={hm.get(sub),i};
                return arr;
            }
            else
            {
                hm.put(nums[i],i);
            }
        }
        int arr1[]=new int[2];
        return arr1;
    }
}