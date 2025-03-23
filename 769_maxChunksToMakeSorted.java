class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}



public class 769_maxChunksToMakeSorted {

    public int maxChunksToSorted2(int arr[])
    {
        int n=arr.length;
        int chunks=0;
        int preMax[]=new int[n];
        int postMin[]=new int[n];
        preMax[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            preMax[i]=Math.max(preMax[i-1],arr[i]);
        }
        postMin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            postMin[i]=Math.min(postMin[i+1],arr[i]);
        }
        for(int i=0;i<n-1;i++)
        {
            if(preMax[i]<=postMin[i+1])
            {
                chunks++;
            }
        }
        return chunks+1; 
    }
}