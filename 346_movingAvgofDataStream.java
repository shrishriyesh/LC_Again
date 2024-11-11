class MovingAverage {
    Queue<Integer> q=new LinkedList<>();
    int s=0;
    int sum=0;
    public MovingAverage(int size) {
        s=size;
    }
    
    public double next(int val) {
        sum+=val;
        if(q.size()>=s)
        {
            sum-=q.poll();
            q.add(val);
        }
        else
        {
            //sum+=val;
            q.add(val);
        }
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */