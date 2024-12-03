// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int tl=nums1.length+nums2.length;
//        int i=0,j=0;
//         while(i<nums1.length && j<nums2.length){
//             if(i+j==tl/2){
//                 if(tl%2==0){
//                     return (Math.max(nums1[i],nums2[j])+Math.min(nums1[i+1],nums2[j+1]))/2.0;
//                 }
//                 else{
//                     return Math.min(nums1[i],nums2[j]);
//                 }
//             }
//             if(nums1[i]<nums2[j]){
//                 i++;
//             }
//             else{
//                 j++;
//             }
//         }
//     }
// }


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tl = nums1.length + nums2.length;
        int i = 0, j = 0;
        int prev = 0, curr = 0; // To keep track of the two middle elements

        while (i < nums1.length || j < nums2.length) {
            prev = curr;

            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }

            // Check if we have reached the middle
            if (i + j == (tl / 2) + 1) {
                if (tl % 2 == 0) {
                    return (prev + curr) / 2.0;
                } else {
                    return curr;
                }
            }
        }
        return 0; // Should not reach here
    }
}
