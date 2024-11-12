class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        if(digits[i]!=9)
        {
            digits[i]=digits[i]+1;
            return digits;
        }
        else
        {
            while(i>0&&digits[i]==9)
            {
                digits[i--]=0;
            }
            if(i>0&&digits[i]!=9)
            {
                digits[i]=digits[i]+1;
                return digits;
            }
            else if(i==0&&digits[i]!=9)
            {
                digits[i]=digits[i]+1;
                return digits;
            }
            else if(i==0&&digits[i]==9)
            {
                int arr[]=new int[digits.length+1];
                arr[0]=1;
                arr[1]=0;
                for(int j=2;j<arr.length;j++)
                {
                    arr[j]=digits[j-1];
                }
                return arr;
            }
    }
    return digits;
//     for (int i = digits.length - 1; i >= 0; i--) {
// 	if (digits[i] < 9) {
// 		digits[i]++;
// 		return digits;
// 	}
// 	digits[i] = 0;
// }

// digits = new int[digits.length + 1];
// digits[0] = 1;
// return digits;
    }
}