class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int l=0;int r=numbers.length-1;
       while(l<r)
       {
        int diff=target-numbers[l];
        if(diff==numbers[r])
        {
            return new int[]{l+1,r+1};
        }
        else if(diff<numbers[r])
        {
            r--;
        }
        else
        {
            l++;
        }
        
       } 
       return new int[]{-1,-1};
    }
}