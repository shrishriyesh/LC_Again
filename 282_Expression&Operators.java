class Solution {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> ans=new ArrayList<>();
        solve(0,num,target,"",ans,0,0);
        return ans;
    }
    public void solve(int index,String num, int target, String currformula, List<String> ans, long prev, long res)
    {
        int n=num.length();
        if(index==n)
        {
            if(res==target)
            ans.add(currformula);
             return;
        }
        String st= "";
        long currRes=0;
        for(int i=index;i<num.length();i++)
        {
            int c=num.charAt(i)-'0';
            if(i>index && num.charAt(index)=='0')break;
            st+=num.charAt(i);
            currRes=currRes*10+(num.charAt(i)-'0');
            if(index==0)
            {
                solve(i+1,num,target,st,ans,currRes,currRes);
            }
            else
            {
                solve(i+1,num,target,currformula+"+"+st,ans,currRes,res+currRes);
                solve(i+1,num,target,currformula+"-"+st,ans,-currRes,res-currRes);
                solve(i+1,num,target,currformula+"*"+st,ans,prev*currRes,res-prev+(prev*currRes));
            }
        }
       
    }
}