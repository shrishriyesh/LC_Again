class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left = left(arr);
        right = right(arr);
        int ans = 0;
        int mod=1_000_000_007;
        long prod=0;
        for(int i=0;i<n;i++){
            prod = ((i-left[i])*(right[i]-i))%mod;
            ans = (int)(ans+(prod*arr[i])%mod)%mod;
        }
        return ans;
    }
    public int[] right(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] right = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
            stack.pop();
            }
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return right;
    }
    public int[] left(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return left;
    }
}