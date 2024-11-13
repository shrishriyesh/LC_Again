class Solution {
    public String simplifyPath(String path) {
        String arr[]=path.split("/");
        String res="";
        // for(String st: arr)
        // {
        //     System.out.println(st);
        // }
        Stack<String> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            String word=arr[i];
            if(word.trim().length()>0)
            {
                if(word.equals("."))
                continue;
                else if(word.equals(".."))
                {
                    if(!st.isEmpty())
                    st.pop();
                    else
                    continue;
                }
                else
                st.push(word);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : st) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
}
}
