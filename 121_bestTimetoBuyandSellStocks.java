class Solution {
    public int maxProfit(int[] prices) {
        int least=prices[0];
        int max=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]-least>max)
            max=prices[i]-least;
            if(prices[i]<least)
            {
                least=prices[i];
            }
        }
        return max;
    }
}