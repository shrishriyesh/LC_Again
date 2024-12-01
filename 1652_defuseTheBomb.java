class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int res[]=new int[n];
        if(k==0)
        return res;
        //if k is negative
        if(k<0){
            k=-k;
            int sum=0;
            for(int i=(n-k)%n;i<n;i++){
                sum+=code[i];
            }
            res[0]=sum;
            for(int i=1;i<n;i++){
                sum+=code[(n-1+i)%n]-code[(n-k-1+i)%n];
                res[i]=sum;
            }
        }
        //if k is positive
        else{
            int sum=0;
            for(int i=1;i<=k;i++){
                sum+=code[i%n];
            }
            res[0]=sum;
            for(int i=1;i<n;i++){
                sum+=code[(i+k)%n]-code[(i)%n];
                res[i]=sum;
            }
        }
        return res;
    }
}