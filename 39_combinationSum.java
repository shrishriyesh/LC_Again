class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        find(0,candidates,target,ds,ans);
        return ans;
    }
    public void find(int i,int[] candidates,int target,List<Integer> ds,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(i==candidates.length || target<0){
            return;
        }
        ds.add(candidates[i]);
        find(i,candidates,target-candidates[i],ds,ans);
        ds.remove(ds.size()-1);
        find(i+1,candidates,target,ds,ans);
        return;
    }
}