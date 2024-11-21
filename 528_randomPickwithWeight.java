class Solution {

    Random r=new Random();
    int w[];
    int cumsum[];
    double sum;
    int l;
    public Solution(int[] w) {
        l=w.length;
        this.w=w;
        cumsum=new int[l];
        cumsum[0]=w[0];
        sum=w[0];
        for(int i=1;i<w.length;i++)
        {
            cumsum[i]=cumsum[i-1]+w[i];
            sum+=w[i];
        }
    }
    
    public int pickIndex() {
        double t=sum*(r.nextDouble());
        int left=0;
        int right=l;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(t>cumsum[mid])
            {
                left=mid+1;
            }
            else
            right=mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */