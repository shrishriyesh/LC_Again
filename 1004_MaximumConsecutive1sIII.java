class Solution {
    public int longestOnes(int[] nums, int k) {
        int fast = 0;
        int slow = 0;
        int maxc = 0;
        int zeros = 0;

        while (fast < nums.length) {
            if (nums[fast] == 0) {
                zeros++;
            }

            // Adjust the window if zeros exceed k
            while (zeros > k) {
                if (nums[slow] == 0) {
                    zeros--;
                }
                slow++;
            }

            // Update the maximum count
            maxc = Math.max(maxc, fast - slow + 1);

            // Move the fast pointer
            fast++;
        }

        return maxc;
    }
}


// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int l=0,r=0;
//         int ans=0;
//         int zero=0;
//         while(r<nums.length){
//             if(nums[r]==0){
//                 zero++;
//             }
//             while(zero>k){
//                 if(nums[l]==0)
//                     zero--;
//                 l++;
//             }
//             ans=Math.max(ans,r-l+1);
//             r++;
//         }
//         return ans;
//     }
// }