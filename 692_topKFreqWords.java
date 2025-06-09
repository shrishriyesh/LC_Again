class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Custom min-heap
        PriorityQueue<String> heap = new PriorityQueue<>(
            (w1, w2) -> {
                int freqCompare = freqMap.get(w1) - freqMap.get(w2);
                if (freqCompare == 0) {
                    return w2.compareTo(w1); // reverse lex
                }
                return freqCompare;
            }
        );

        // Step 3: Push to heap and keep size <= k
        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Build result list from heap
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result); // get most frequent first
        return result;
    }
}
