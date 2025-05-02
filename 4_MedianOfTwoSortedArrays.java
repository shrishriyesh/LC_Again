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


///Using Binary Search

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int l=0;
        int r=x;
        while(l<=r)
        {
            int partX=(l+r)/2;
            int partY=(x+y+1)/2-partX;
            int maxLX=(partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            int minRX=(partX==x)?Integer.MAX_VALUE:nums1[partX];
            int maxLY=(partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            int minRY=(partY==y)?Integer.MAX_VALUE:nums2[partY];
            if(maxLX<=minRY && maxLY<=minRX)
            {
                if((x+y)%2==0)
                {
                    return (Math.max(maxLX,maxLY)+Math.min(minRX,minRY))/2.0;
                }
                else
                {
                    return Math.max(maxLX,maxLY);
                }
            }
            else if(maxLX>minRY)
            {
                r=partX-1;
            }
            else
            {
                l=partX+1;
            }
        }
        return -1;
    }
}