class Solution {
    public int kthFactor(int n, int k) {
        int num=1;
        while(num<=n &&k>=0)
        {
            if(n%num==0)
            k--;
            if(k==0)
            return num;
            num++;
        }
        return -1;
    }
}