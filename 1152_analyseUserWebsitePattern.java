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
            for(int i=0;i<n-2;i++){
                String sites= visits.get(i).site + visits.get(i+1).site + visits.get(i+2).site;
                patterns.add(sites);
                patternCount.put(sites, patternCount.getOrDefault(sites, 0) + 1);
                if(patternCount.get(sites) > maxCount){
                    maxCount = patternCount.get(sites);
                    result.clear();
                    result.add(visits.get(i).site);
                    result.add(visits.get(i+1).site);
                    result.add(visits.get(i+2).site);
                    maxPattern = sites;
                }
                else if(patternCount.get(sites) == maxCount){
                    if(maxPattern.compareTo(sites) > 0){
                        maxPattern = sites;
                        result.clear();
                        result.add(visits.get(i).site);
                        result.add(visits.get(i+1).site);
                        result.add(visits.get(i+2).site);
                    }
                }

            }
        }
        return result;

    }
}