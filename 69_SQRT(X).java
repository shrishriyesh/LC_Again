class Solution {
    int res=0;
    public int mySqrt(int x) {
        if(x==0) return 0;
        while(res*res<=x){
            res++;
        }
        return res-1;
    }
}


class Solution {
    int res=0;
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        int l=1;
        int r=x;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(mid==x/mid) return mid;
            else if(mid<x/mid) l=mid+1;
            else r=mid-1;
        }
        return r;
    }
}