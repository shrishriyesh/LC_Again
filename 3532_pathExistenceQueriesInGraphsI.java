class Solution {
  public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    boolean res[]=new boolean[queries.length];
    int group[]=new int[n];
    group[0]=0;
    for(int i=1;i<n;i++){
       if(nums[i]-nums[i-1]>maxDiff)
        group[i]=group[i-1]+1;
       else
        group[i]=group[i-1];
    }
    for(int i=0;i<queries.length;i++){
      int u=queries[i][0];
      int v=queries[i][1];
      if(group[u]==group[v])
        res[i]=true;
      else
        res[i]=false;
    }
    return res;
  }
}