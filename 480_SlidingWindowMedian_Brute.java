class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
       double res[]=new double[nums.length-k+1];
       ArrayList<Integer> window = new ArrayList<>();
       int j = 0;
       for(int i=0;i<nums.length;i++){
           int index = Collections.binarySearch(window,nums[i]);
           if(index<0) index = -index-1;
           window.add(index,nums[i]);
           if(window.size()>k){
               window.remove(Collections.binarySearch(window,nums[i-k]));
           }
           if(window.size()==k){
               if(k%2==0){
                   res[j++] = window.get(k/2)/2.0+window.get(k/2-1)/2.0;
               }else{
                     res[j++] = window.get(k/2);
               }
           }
       }
         return res;
     
    }
}