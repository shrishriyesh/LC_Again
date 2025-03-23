class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String x: tokens) 
        {
            if(isNumeric(x)) 
            {
                stack.push(Integer.parseInt(x));
            } 
            else 
            {
                int b = stack.pop();
                int a = stack.pop();
                if(x.equals("+")) 
                {
                    stack.push(a + b);
                } 
                else if(x.equals("-")) 
                {
                    stack.push(a - b);
                } 
                else if(x.equals("*")) 
                {
                    stack.push(a * b);
                } 
                else if(x.equals("/")) 
                {
                    stack.push(a / b);
                }
            }

        }
        return stack.pop();
    }
    public boolean isNumeric(String x)
    {
        if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/"))
        return false;
        else
        return true;
    }
}