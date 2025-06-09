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