class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[nums.length];
        for(int i=2*nums.length-1;i>=0;i--)
        {
            int index=i%nums.length;
            if(st.isEmpty())
            {
                res[index]=-1;
                st.push(nums[index]);
            }
            else
            {
                while(!st.isEmpty()&&st.peek()<=nums[index])
                st.pop();
                if(!st.isEmpty())
                res[index]=st.peek();
                else
                {
                    res[index]=-1;
                }
                st.push(nums[index]);
            }
        }
        return res;
    }
}