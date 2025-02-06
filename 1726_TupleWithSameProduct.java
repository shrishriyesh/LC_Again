class Solution {
    public int tupleSameProduct(int[] nums) {
        int l=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                int prod=nums[i]*nums[j];
                if(map.containsKey(prod)){
                    ans+=map.get(prod);
                }
                map.put(prod,map.getOrDefault(prod,0)+1);
            }
        }
        return ans*8;
    }
}