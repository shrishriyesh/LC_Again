class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k){
            return false;
        }
        if(s.length()==k){
            return true;
        }
        char[] arr=new char[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        int oddcount=0;
        for(int i=0;i<26;i++){
            if(arr[i]%2!=0){
                oddcount++;
            }
        }
        if(oddcount>k){
            return false;
        }
        return true;
    }
}