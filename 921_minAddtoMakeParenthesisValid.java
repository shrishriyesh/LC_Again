class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(st.isEmpty()||c=='(')
            {
                st.push(c);
            }
            else
            {
                    if(st.peek()=='(')
                    st.pop();
                    else
                    st.push(c);
            }
        }
        return st.size();
    }
    
}