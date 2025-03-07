class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null; // Fix: Proper base case check

        int mid = n / 2;
        TreeNode head = new TreeNode(nums[mid]);

        // Fix: Correct array sizes
        int arrL[] = new int[mid]; 
        int arrR[] = new int[n - mid - 1]; 

        for (int i = 0; i < mid; i++) {
            arrL[i] = nums[i]; // Fix: Correctly copying left half
        }
        for (int i = mid + 1, j = 0; i < n; i++, j++) {
            arrR[j] = nums[i]; // Fix: Correctly copying right half
        }

        head.left = sortedArrayToBST(arrL);
        head.right = sortedArrayToBST(arrR);

        return head;
    }
}