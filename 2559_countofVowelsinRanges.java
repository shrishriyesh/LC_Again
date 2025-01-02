class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int arr[] = new int[n+1];
        arr[0] = 0;
        for(int i=1;i<=n;i++){
            if(isVowel(words[i-1].charAt(0))&&isVowel(words[i-1].charAt(words[i-1].length()-1))){
                arr[i] = arr[i-1]+1;
            }else{
                arr[i] = arr[i-1];
            }
        }
        int m = queries.length;
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = arr[r]-arr[l-1];
        }
        return ans;
    }
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}