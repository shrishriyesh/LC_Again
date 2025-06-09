class Solution {
     Map<String, String> map;   // Stores raw replacements
    Map<String, String> memo;  // Memoization cache
    public String applySubstitutions(List<List<String>> replacements, String text) {
       map = new HashMap<>();
        memo = new HashMap<>();

        // Build the mapping
        for (List<String> pair : replacements) {
            map.put(pair.get(0), pair.get(1));
        }

        // Build final result from the input text
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); ) {
            if (text.charAt(i) == '%' && i + 2 < text.length() && text.charAt(i + 2) == '%') {
                String key = String.valueOf(text.charAt(i + 1));
                result.append(resolve(key));
                i += 3;
            } else {
                result.append(text.charAt(i++));
            }
        }

        return result.toString();
    }

    // Method to recursively resolve placeholder strings
    private String resolve(String key) {
        if (memo.containsKey(key)) return memo.get(key);

        String val = map.get(key);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length(); ) {
            if (val.charAt(i) == '%' && i + 2 < val.length() && val.charAt(i + 2) == '%') {
                String innerKey = String.valueOf(val.charAt(i + 1));
                sb.append(resolve(innerKey));
                i += 3;
            } else {
                sb.append(val.charAt(i++));
            }
        }

        String expanded = sb.toString();
        memo.put(key, expanded);
        return expanded;
    }
}
// TopSort Approach:

class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        
        HashMap<String, String> replacementMap = new HashMap<>();

        Map<String, List<String>> graph = new HashMap<>();

        Map<String, Integer> indegreeMap = new HashMap<>();

        for (List<String>replacement : replacements){
            String key = replacement.get(0);
            String value = replacement.get(1);

            int i = 0;
            graph.putIfAbsent(key, new ArrayList<>());
            indegreeMap.put(key, 0);
            while (i< value.length()){
                if (value.charAt(i) != '%'){
                    i += 1;
                }else{
                    // collecting all the dependecies. for eg. abc%B%de%A%
                    i += 1;
                    String neighborKey = String.valueOf(value.charAt(i));
                    graph.putIfAbsent(neighborKey, new ArrayList<>());
                    graph.get(neighborKey).add(key);
                    indegreeMap.put(key, indegreeMap.get(key)+1);
                    i += 2;
                    
                }
            }
            replacementMap.put(key, value);
        }

        Queue<String> q = new LinkedList<>();

        for (String key : indegreeMap.keySet()){
            if (indegreeMap.get(key) == 0){
                q.add(key);
            }
        }

        while (q.size() > 0){
            String curr = q.poll();

            StringBuilder sb = new StringBuilder();
            String currRes = replacementMap.get(curr);

            int i = 0;
            while (i < currRes.length()){
                if (currRes.charAt(i) != '%'){
                    sb.append(currRes.charAt(i));
                    i += 1;
                }else{
                    // getting the values of all the dependencies for the curr key.
                    i += 1;
                    sb.append(replacementMap.get(String.valueOf(currRes.charAt(i))));
                    i += 2;
                }
            }
            replacementMap.put(curr, sb.toString());

            for (String neighbor : graph.get(curr)){
                indegreeMap.put(neighbor, indegreeMap.get(neighbor)-1);
                if (indegreeMap.get(neighbor) == 0){
                    q.add(neighbor);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i< text.length()){
            if (text.charAt(i) != '%'){
                ans.append(text.charAt(i));
                i += 1;
            }else{
                i += 1;
                String key = String.valueOf(text.charAt(i));
                ans.append(replacementMap.get(key));
                i += 2;
            }
        }

        return ans.toString();
    }
}