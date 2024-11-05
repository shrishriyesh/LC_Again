class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(st.isEmpty())
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.peek()==s.charAt(i))
                {
                    st.pop();
                }
                else
                st.push(s.charAt(i));
            }
        }
        String res="";
        while(!st.isEmpty())
        {
            res=res+st.pop();
        }
        StringBuilder rev= new StringBuilder();
        rev.append(res);
        rev.reverse();
        return rev.toString();
        
    }
}