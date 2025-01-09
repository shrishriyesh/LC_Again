//Approach: I will create a map of number and its position in the array.
// Runtime: O(n^2) Slower than needed
//
// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         //map of number and position
//      HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
//      for(int i=0;i<nums.length;i++)
//      {
//         if(!map.containsKey(nums[i]))
//         {
//             ArrayList<Integer> temp= new ArrayList<>();
//             temp.add(i);
//             map.put(nums[i],temp);
//         }
//         else
//         {
//             map.put(nums[i],map.get(nums[i]).add(i));
//         }
//      }   

//         long count=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=i+1;j<nums.length;j++)
//             {
//                 if(nums[i]+nums[j]>=lower && nums[i]+nums[j]<=upper)
//                 {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

//Approach: I will sort the array and then use two pointer approach to find the number of pairs that are fair.
// Runtime: O(nlogn) as it is a sort of binary search
class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }
}