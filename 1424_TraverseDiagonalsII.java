class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> mp=new HashMap<>();
        for(int i=nums.size()-1;i>=0;i--)
        {
            for(int j=0;j<nums.get(i).size();j++)
            {
                if(mp.containsKey(i+j))
                {
                    mp.get(i+j).add(nums.get(i).get(j));
                }
                else
                {
                    ArrayList<Integer> out= new ArrayList<>();
                    out.add(nums.get(i).get(j));
                    mp.put(i+j,out);
                }
            }
        }
        
    int i=0;
    while(mp.containsKey(i)==true)
    {
        for(int j=0;j<mp.get(i).size();j++)
        {
            res.add(mp.get(i).get(j));
        }
        i++;
    }
    int[] ans = new int[res.size()];
    for(int j=0;j<res.size();j++)
        ans[j]=res.get(j);
    return ans;
    }
}