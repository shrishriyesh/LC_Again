class Solution {
    public int getLargestOutlier(int[] nums) {
      HashMap <Integer, Integer> map = new HashMap<>();
      int sum=0;
      for(int i=0; i<nums.length; i++){
          sum+=nums[i];
          map.put(2*nums[i], map.getOrDefault(nums[i]*2, 0)+1);
      }
      int maxres=Integer.MIN_VALUE;
      for(int i=0; i<nums.length; i++){
         int x=sum-nums[i];
         if (map.getOrDefault(x, 0) >= 2 || (map.getOrDefault(x, 0) == 1 && x!= nums[i] * 2)){
           // if(map.get(x)==1||map.get(x)>=2&&x!=nums[i]*2)
             maxres=Math.max(maxres, nums[i]);
         }
      }
        return maxres;
    }
}