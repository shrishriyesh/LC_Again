class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 1;
        for(; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                break;
            }
        }
        if(i<=0) return -1;
        int j = nums.length - 1;
        while(i<j) {
            if(nums[j] > nums[i - 1]) {
                break;
            }
            j--;
        }
        char temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;
        Arrays.sort(nums, i, nums.length);
        long res = Long.parseLong(new String(nums));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
}