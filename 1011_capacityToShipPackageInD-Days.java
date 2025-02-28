class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=0;
        int r=0;
        int i=0;
        for(i=0;i<n;i++){
            l=Math.max(l,weights[i]);
            r+=weights[i];
        }
        while(l<r){
            int mid=(l+r)/2;
            if(isValid(weights,days,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean isValid(int weights[],int days,int x){
        int sum=0;
        int d=1;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>x){
                d++;
                sum=weights[i];
            }
        }
        return d<=days;
    }
}