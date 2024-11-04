class Solution {
    public int findKthPositive(int[] arr, int k) {
     int i=1;
    int missnum=0;
    int j=0;
    while(k!=0)
    {
        if(k==0)
        {
            break;
        }
        if(j<arr.length&&arr[j]==i)
        {
            i++;
        j++;
           
        }
        else
        {
             k--;
            missnum=i;
            i++;
        }

    }
    return missnum;
    }
}