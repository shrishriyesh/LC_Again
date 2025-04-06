class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int nextright[] = new int[n];
        int prevleft[] = new int[n];
        int candlesAndPlates[][] = new int[n][2];
        int result[] = new int[queries.length];
        prevleft[0] = (s.charAt(0) == '|') ? 0 : -1;
        candlesAndPlates[0][0] = (s.charAt(0) == '|') ? 1 : 0;
        candlesAndPlates[0][1] = (s.charAt(0) == '*') ? 1 : 0;
        for(int i=1;i<n;i++){
            if(s.charAt(i) == '|'){
                prevleft[i] = i;
            }else{
                prevleft[i] = prevleft[i-1];
            }
            candlesAndPlates[i][0] = candlesAndPlates[i-1][0]+((s.charAt(i) == '|') ? 1 : 0);
            candlesAndPlates[i][1] = candlesAndPlates[i-1][1]+((s.charAt(i) == '*') ? 1 : 0);
        }
        nextright[n-1] = (s.charAt(n-1) == '|') ? n-1 : -1;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i) == '|'){
                nextright[i] = i;
            }else{
                nextright[i] = nextright[i+1];
            }
        }
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int leftCandle = nextright[left];
            int rightCandle = prevleft[right];
            if (leftCandle == -1 || rightCandle == -1 || leftCandle > rightCandle) {
    result[i] = 0;
} else {
    result[i] = candlesAndPlates[rightCandle][1] - candlesAndPlates[leftCandle][1];
}
        }
        return result;
    }
}