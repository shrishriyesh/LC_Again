class SparseVector {
    class pair
    {
        int index;
        int val;
        pair(int a,int b)
        {
            index=a;
            val=b;
        }
    }
    ArrayList<pair> arr=new ArrayList<>();
    
    SparseVector(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                pair x=new pair(i,nums[i]);
                arr.add(x);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum=0;
        int p=0;int q=0;
        while(p<vec.arr.size()&&q<arr.size())
        {
            if(vec.arr.get(p).index==arr.get(q).index)
            {
                sum+=vec.arr.get(p++).val*arr.get(q++).val;
            }
            else if(vec.arr.get(p).index>arr.get(q).index)
            q++;
            else
            p++;
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);