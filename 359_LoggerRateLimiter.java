class Logger {
   Queue<Pair<Integer, String>> queue;
    Set<String> recent;

    public Logger() {
        queue = new LinkedList<>();
        recent = new HashSet<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // Clean up old messages
        while (!queue.isEmpty() && queue.peek().getKey() <= timestamp - 10) {
            String oldMsg = queue.poll().getValue();
            recent.remove(oldMsg);
        }

        if (recent.contains(message)) return false;

        queue.offer(new Pair<>(timestamp, message));
        recent.add(message);
        return true;
    }
    }

// Time Complexity: O(1) for each message check
// Space Complexity: O(n) for storing messages in the map and queue
// This implementation uses a queue to keep track of the order of messages and a map to store the last timestamp for each message.

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

 public class Logger {
    private int[] buckets;
    private Set[] sets;
    /** Initialize your data structure here. */
    public Logger() {
        buckets = new int[10];
        sets = new Set[10];
        for (int i = 0; i < sets.length; ++i) {
            sets[i] = new HashSet<String>();
        }
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int idx = timestamp % 10;
        if (timestamp != buckets[idx]) {
            sets[idx].clear();
            buckets[idx] = timestamp;
        }
        for (int i = 0; i < buckets.length; ++i) {
            if (timestamp - buckets[i] < 10) {
                if (sets[i].contains(message)) {
                    return false;
                }
            }
        } 
        sets[idx].add(message);
        return true;
    }
}