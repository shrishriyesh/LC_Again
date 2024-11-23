public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum=0;
        HashMap<Integer,Integer> conssum=new HashMap<>();
        conssum.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(conssum.containsKey(sum-k))
            {
                count+=conssum.get(sum-k);
                conssum.put(sum,conssum.getOrDefault(sum,0)+1);
            }
            else
            {
                conssum.put(sum,conssum.getOrDefault(sum,0)+1);
            }
        }
        return count;
    }
}