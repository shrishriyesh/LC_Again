class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i=0;
        int j=0;
        ArrayList<int[]> res=new ArrayList<>();
        while(i<nums1.length&&j<nums2.length)
        {
            
            if(nums1[i][0]==nums2[j][0])
            {
                int arr[]=new int[2];
                arr[0]=nums1[i][0];
                arr[1]=nums1[i][1]+nums2[j][1];
                i++;
                j++;
                res.add(arr);
                continue;
            }
            while((i<nums1.length&&j<nums2.length)&&nums1[i][0]<nums2[j][0])
            {
                int arr[]=new int[2];
                arr[0]=nums1[i][0];
                arr[1]=nums1[i][1];
                i++;
                res.add(arr);
                continue;
            }
             while((i<nums1.length&&j<nums2.length)&&nums1[i][0]>nums2[j][0])
            {
                int arr[]=new int[2];
                arr[0]=nums2[j][0];
                arr[1]=nums2[j][1];
                j++;
                res.add(arr);
                continue;
            }
        }
        
        while(i<nums1.length)
        {
            int arr[]=new int[2];
            arr[0]=nums1[i][0];
                arr[1]=nums1[i][1];
                i++;
                res.add(arr);
        }
         while(j<nums2.length)
        {
            int arr[]=new int[2];
            arr[0]=nums2[j][0];
                arr[1]=nums2[j][1];
                j++;
                res.add(arr);
        }
        int out[][]=new int[res.size()][2];
        for(int k=0;k<res.size();k++)
        {
            out[k][0]=res.get(k)[0];
            out[k][1]=res.get(k)[1];
        }
        return out;
    }

}