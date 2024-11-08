class Solution {
    public int numIdenticalPairs(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int c=0;
       for(int i=0;i<nums.length;i++)
       {
        int num=nums[i];
        if(map.containsKey(num))
        {
            c+=map.get(num);
            map.put(num,map.get(num)+1);
        }
        else
        {
            map.put(num,1);
        }
       } 
       return c;
    }
}