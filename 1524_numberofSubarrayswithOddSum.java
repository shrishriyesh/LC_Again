class Solution 
{
    public int numOfSubarrays(int[] arr) 
    {
        // Step 1: Initialize counters
        int oddCount = 0, evenCount = 1; 
        final int MOD = 1_000_000_007;
        int currSum = 0, result = 0;
        
        // Step 2: Iterate over the array
        for (int num : arr)
        { 
            currSum += num;

            // Step 3: If prefix sum is even
            if (currSum % 2 == 0)
            { 
                result = (result + oddCount) % MOD;
                evenCount++;
            }
            
            // Step 4: If prefix sum is odd
            else
            { 
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        // Step 5: Return the count of subarrays with odd sum
        return result;
    }
}