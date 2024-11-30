class MedianFinder {
    ArrayList<list> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size() == 0){
            list.add(num);
        }else
        {
            int left=0;
            int right=list.size()-1;
            while(left<=right)
            {
                int mid = left + (right-left)/2;
                if(list.get(mid) < num)
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
            list.add(left,num);
        }
    }
    
    public double findMedian() {
        if(list.size()%2==0)
        {
            return (list.get(list.size()/2) + list.get(list.size()/2-1))/2.0;
        }
        else
        {
            return list.get(list.size()/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */