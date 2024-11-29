class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
       List<List<Integer>> res = new ArrayList<>();
        //De-Encoding
       ArrayList<Integer> list1 = new ArrayList<>();
         ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<encoded1.length;i++){
            for(int j=0;j<encoded1[i][1];j++){
                list1.add(encoded1[i][0]);
            }
        }
        for(int i=0;i<encoded2.length;i++){
            for(int j=0;j<encoded2[i][1];j++){
                list2.add(encoded2[i][0]);
            }
        }
        //Multiplying
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            list3.add(list1.get(i)*list2.get(i));
        }
        // Encoding
int count = 1; // Initialize count for the first element
for (int i = 0; i < list3.size() - 1; i++) {
    // Check if the current value is equal to the next value
    if (list3.get(i).equals(list3.get(i + 1))) {
        count++; // Increment the count for the current segment
    } else {
        // If the value changes, create a new segment
        List<Integer> temp = new ArrayList<>();
        temp.add(list3.get(i)); // Add the current value
        temp.add(count); // Add the frequency
        res.add(temp); // Add the segment to the result
        count = 1; // Reset count for the new value
    }
}

// Handle the last segment
List<Integer> temp = new ArrayList<>();
temp.add(list3.get(list3.size() - 1)); // Add the last value
temp.add(count); // Add the frequency of the last segment
res.add(temp);

        return res;
    }
}