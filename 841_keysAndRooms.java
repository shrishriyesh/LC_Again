class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        int res[]=new int[rooms.size()];
        q.add(0);
        for(int i=0;i<rooms.get(0).size();i++)
        {
            q.add(rooms.get(0).get(i));
        }
        res[0]=1;
        q.poll();
        while(!q.isEmpty())
        {
            int x=q.poll();
            if(res[x]==0)
            {
                res[x]=1;
                for(int i=0;i<rooms.get(x).size();i++)
                {
                    q.add(rooms.get(x).get(i));
                }
            }
        }
        for(int i=0;i<res.length;i++)
        {
            if(res[i]==0)
            {
                return false;
            }
        }
        return true;
    }
}