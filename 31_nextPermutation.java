public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



// class Solution {
//     public void nextPermutation(int[] nums) {
//         int x=-1;
//         for(int i=nums.length-2;i>=0;i++)
//         {
//             if(nums[i]<nums[i+1])
//             {
//                 x=i;
//                 break;
//             }
//         }
//         if(x==-1)
//         {
//             Arrays.sort(nums);
//             return;
//         }
//         else
//         {
//             int y=-1;
//             for(int i=nums.length-1;i>x;i--)
//             {
//                 if(nums[i]>nums[x])
//                 {
//                     y=i;
//                     break;
//                 }
//             }
//             int temp=nums[x];
//             nums[x]=nums[y];
//             nums[y]=temp;
//             Arrays.sort(nums,x+1,nums.length);
//         }
//     }
// }