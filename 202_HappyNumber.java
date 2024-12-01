class Solution {
    public boolean isHappy(int n) {
        int pow[]=new int[10];
        for(int i=0;i<10;i++)
            pow[i]=i*i;
        int slow=n,fast=n;
        while(true)
        {
            slow=next(slow,pow);
            fast=next(next(fast,pow),pow);
            if(slow==fast)
                break;
        }
        return slow==1;
    }
    public int next(int n,int pow[])
    {
        int sum=0;
        while(n>0)
        {
            sum+=pow[n%10];
            n/=10;
        }
        return sum;
    }
}