class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res= new ArrayList<>();
        backtracking(nums,new ArrayList<Integer>(),0);
        return res;
    }
    private void backtracking(int[] nums, List<Integer> tempList, int start) {
    res.add(new ArrayList<>(tempList));
    
    for(int i = start; i < nums.length; i++) {
        // Skip duplicates
        if(i > start && nums[i] == nums[i-1]) continue;
        
        tempList.add(nums[i]);
        backtracking(nums,tempList, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
}