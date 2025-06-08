class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l=1;
        int r=0;
        for(int i:bloomDay) r=Math.max(r,i);
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canMake(bloomDay,mid,m,k)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay,int day,int m,int k){
        int count=0;
        int bouquet=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
                if(count==k){
                    bouquet++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return bouquet>=m;
    }
}