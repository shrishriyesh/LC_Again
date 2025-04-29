class Solution {
    class The_Comparator implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            return list1.get(0) - list2.get(0);
        }
    }
    
    private int findMaxProfit(List<List<Integer>> jobs) {
        int n = jobs.size(), maxProfit = 0;
        // min heap having {endTime, profit}
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new The_Comparator());
        
        for (int i = 0; i < n; i++) {
            int start = jobs.get(i).get(0), end = jobs.get(i).get(1), profit = jobs.get(i).get(2);
            
            // keep popping while the heap is not empty and
            // jobs are not conflicting
            // update the value of maxProfit
            while (pq.isEmpty() == false && start >= pq.peek().get(0)) {
                maxProfit = Math.max(maxProfit, pq.peek().get(1));
                pq.remove();
            }
            
            ArrayList<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit + maxProfit);
            
            // push the job with combined profit
            // if no non-conflicting job is present maxProfit will be 0
            pq.add(combinedJob);
        }
        
        // update the value of maxProfit by comparing with
        // profit of jobs that exits in the heap
        while (pq.isEmpty() == false) {
            maxProfit = Math.max(maxProfit, pq.peek().get(1));
            pq.remove();
        }
        
        return maxProfit;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            
            jobs.add(currJob);
        }
        
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        return findMaxProfit(jobs);
    }
}

//DP method using a Binary search for upper bound and DP on end time.
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int jobs[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        Arrays.sort(jobs,(a,b)->(a[1]-b[1]));
        int dp[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            int lastJob=upperBound(jobs,i,jobs[i][0]);
            dp[i+1]=Math.max(dp[i],dp[lastJob]+jobs[i][2]);
        }
        return dp[n];
    }
    public int upperBound(int jobs[][],int r,int target)
    {
        int l=0;
        while(l<r)
        {
            int mid=(l+r)/2;
            if(jobs[mid][1]<=target)
            {
                l=mid+1;
            }
            else
            r=mid;
        }
        return l;
    }
}