class RandomizedSet {
    HashMap<Integer,Integer> mp;
    List<Integer> arr;
    int size;
    Random rand=new Random();
    public RandomizedSet() {
        mp=new HashMap<>();
        arr=new ArrayList<Integer>();
        size=0;
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)&&mp.get(val)!=-1)
        return false;
        else
        {
            arr.add(size,val);
            size++;
            mp.put(val,size-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!mp.containsKey(val)||mp.get(val)==-1)
        return false;
        else
        {
            int pos=mp.get(val);
            int t=arr.get(size-1);
            arr.set(pos,t);
            mp.put(t,pos);
            size--;
            mp.put(val,-1);
            arr.remove(size);
            return true;
        }
        
    }
    
    public int getRandom() {
        return arr.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */