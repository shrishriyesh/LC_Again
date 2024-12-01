class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] greaterInteger2=nextGreaterElements(nums2);
        int[] greaterInteger1=new int[nums1.length];
        for(int i=0;i<nums2.length;i++)
        {
            hm.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++)
        {
            int pos=hm.get(nums1[i]);
            greaterInteger1[i]=greaterInteger2[pos];
        }
        return greaterInteger1;
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                res[i]=-1;
                st.push(nums[i]);
            }
            else
            {
                while(!st.isEmpty()&&st.peek()<nums[i])
                st.pop();
                if(!st.isEmpty())
                res[i]=st.peek();
                else
                {
                    res[i]=-1;
                }
                st.push(nums[i]);
            }
        }
        return res;
    }
}