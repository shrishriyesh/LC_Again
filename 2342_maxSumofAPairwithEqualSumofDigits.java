class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            int n = nums[i];
            while(n>0){
                sum += n%10;
                n /= 10;
            }
            if(!map.containsKey(sum)){
                map.put(sum,new ArrayList<>());
            }
            map.get(sum).add(nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            ArrayList<Integer> list = map.get(key);
            if(list.size()>1){
                // Collections.sort(list);
                // max = Math.max(max,list.get(list.size()-1)+list.get(list.size()-2));
                int max1 = Integer.MIN_VALUE;
                int max2 = Integer.MIN_VALUE;
                for(int x:list){
                    if(x>max1){
                        max2 = max1;
                        max1 = x;
                    }else if(x>max2){
                        max2 = x;
                    }
                }
                max = Math.max(max,max1+max2);
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}