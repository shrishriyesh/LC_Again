class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int c=0;
        StringBuilder st=new StringBuilder();
        while(i>=0 &&j>=0)
        {
            int x=num1.charAt(i)-'0';
            int y=num2.charAt(j)-'0';
            int sum=(x+y+c)%10;
            c=(x+y+c)/10;
            st.append(sum);
            i--;
            j--;
        }
        while(i>=0)
        {
            int x=(num1.charAt(i)-'0'+c)%10;
            c=(num1.charAt(i)-'0'+c)/10;
            st.append(x);
            i--;
        }
        while(j>=0)
        {
            int x=(num2.charAt(j)-'0'+c)%10;
            c=(num2.charAt(j)-'0'+c)/10;;
            st.append(x);
            j--;
        }
        if(c>0)
        st.append(c);
        return st.reverse().toString();
    }
}