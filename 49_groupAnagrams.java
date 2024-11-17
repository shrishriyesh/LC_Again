class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String k=new String(arr);
            if(!map.containsKey(k))
            {
                ArrayList<String> out=new ArrayList<>();
                out.add(strs[i]);
                map.put(k,out);
            }
            else
            {
                map.get(k).add(strs[i]);
            }
        }
        return new ArrayList(map.values());
    }
}