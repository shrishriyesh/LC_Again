import java.util.List;

class Solution {
    class Visit{
        int time;
        String site;
        Visit(int time,String site){
            this.time = time;
            this.site = site;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Visit>> userVisits = new HashMap<>();
        for(int i=0;i<username.length;i++){
            String user = username[i];
            int time = timestamp[i];
            String site = website[i];
            userVisits.putIfAbsent(user, new ArrayList<>());
            userVisits.get(user).add(new Visit(time, site));
        }
        HashMap<String, Integer> patternCount = new HashMap<>();
        int maxCount = 0;
        List<String> result = new ArrayList<>();
        String maxPattern = "";
        for(String user : userVisits.keySet())
        {
            List<Visit> visits = userVisits.get(user);
            Collections.sort(visits, (a, b) -> a.time - b.time);
            int n = visits.size();
            HashSet<String> patterns
                    = new HashSet<>();
            if(n < 3) continue;
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        String patternofString = visits.get(i).site + " " + visits.get(j).site + " " + visits.get(k).site;
                        if(patterns.contains(patternofString)) continue;
                        patterns.add(patternofString);
                        patternCount.put(patternofString, patternCount.getOrDefault(patternofString, 0) + 1);
                        if(patternCount.get(patternofString) > maxCount)
                        {
                            maxCount = patternCount.get(patternofString);
                            maxPattern = patternofString;
                        }
                        else if(patternCount.get(patternofString) == maxCount)
                        {
                            if(maxPattern.compareTo(patternofString) > 0)
                            {
                                maxPattern = patternofString;
                            }
                        }
                    }
                }
            }
        }
        String[] maxPatternArray = maxPattern.split(" ");
        for(String s : maxPatternArray)
        {
            result.add(s);
        }
        return result;

    }
}