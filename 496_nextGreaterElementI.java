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



//2nd approach
//Checked all the elements of nums2 to see if stack has a greater element or not
//If not then push the element in stack
//If yes then pop the element from stack and check if it is present in nums1 or not
//If present then assign the value to the result array
//If not present then pop the element from stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<nums1.length;i++)
        {
            if(!map.containsKey(nums1[i]))
            {
                map.put(nums1[i],i);
            }
        }
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && stack.peek() < nums2[i])
            {   if(map.containsKey(stack.peek()))
                {
                    int index = map.get(stack.pop());
                    result[index] = nums2[i];
                }
                else
                {
                    //result[map.get(stack.peek())] = -1;
                    stack.pop();
                }
            }
            if(map.containsKey(nums2[i]))
            {
                stack.push(nums2[i]);
            }
        }
        while(!stack.isEmpty())
        {
            int index = map.get(stack.pop());
            result[index] = -1;
        }
        return result;
    }
}