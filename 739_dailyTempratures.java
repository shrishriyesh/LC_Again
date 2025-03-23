class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int res[]= new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(!stack.isEmpty())
            {
                if(temperatures[stack.peek()]>temperatures[i])
                {
                res[i]=stack.peek()-i;
                break;
                }
                else
                {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }
}