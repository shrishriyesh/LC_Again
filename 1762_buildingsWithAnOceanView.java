class Solution {
    public int[] findBuildings(int[] heights) {
        int l=heights.length-1;
        ArrayList<Integer> res=new ArrayList<>();
        res.add(l);
        if(l<=0)
        {
            int arr[]=new int[res.size()];
            arr[res.size()-1]=res.get(res.size()-1);
            return arr;
        }
        int bb=heights[l];
        for(int i=l-1;i>=0;i--)
        {
            if(heights[i]>bb)
            {
                bb=heights[i];
                res.add(i);
            }
        }
        int arr[]=new int[res.size()];
        int j=0;
        for(int i=res.size()-1;i>=0;i--)
        {
            arr[j++]=res.get(i);
        }
        return arr;

    }
}