class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> first = new ArrayList<>();
        while(numRows-- > 0){
            List<Integer> row = new ArrayList<>();
            if(res.size() == 0){
                row.add(1);
            }else{
                row.add(1);
                for(int i = 1; i < res.size(); i++){
                    row.add(res.get(res.size()-1).get(i-1) + res.get(res.size()-1).get(i));
                }
                row.add(1);
            }
            res.add(row);
        }
        return res;
    }
}