class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int x: candies)
        {
            max=Math.max(x,max);
        }
        ArrayList<Boolean> res=new ArrayList<>();
        for(int i: candies)
        {
            int sum=i+extraCandies;
            if(sum>=max)
            res.add(true);
            else
            res.add(false);
        }
        return res;
    }
}