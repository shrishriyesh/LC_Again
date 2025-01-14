class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int c=0;
        int map[]=new int[A.length+1];
        int res[]=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            map[A[i]]++;
            if(map[A[i]]==2)
            c++;
            map[B[i]]++;
            if(map[B[i]]==2)
            c++;
            res[i]=c;
        }
        return res;
    }
}