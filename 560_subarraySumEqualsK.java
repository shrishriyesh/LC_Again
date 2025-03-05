public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

///Approach 2: Using Contiguous sum and Hashmap to store the sum and its frequency and then checking if sum-k is present in the map
/// 
/// 
/// class Solution {
// public int subarraySum(int[] nums, int k) {
//     HashMap<Integer,Integer> map=new HashMap<>();
//     int sum=0;
//     int res=0;
//     map.put(0,1);
//     for(int i=0;i<nums.length;i++)
//     {
//         sum+=nums[i];
//         if(map.containsKey(sum-k))
//         {
//             res+=map.get(sum-k);
//         }
//         map.put(sum,map.getOrDefault(sum,0)+1);
//     }
//     return res;
// }
// }