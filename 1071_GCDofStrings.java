class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if((str1 + str2).equals(str2 + str1)) {
            int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
        }
        return "";
    }
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
        // if(b == 0) {
        //     return a;
        // }
        // return gcd(b,a % b);
        //
        //
    }
}