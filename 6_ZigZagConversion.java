//ZigZag Conversion
class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<Character>());
        }
        int i = 0;
        while(i < s.length()){
            for(int j = 0; j < numRows && i < s.length(); j++){
                list.get(j).add(s.charAt(i));
                i++;
            }
            for(int j = numRows - 2; j > 0 && i < s.length(); j--){
                list.get(j).add(s.charAt(i));
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < numRows; j++){
            for(int k = 0; k < list.get(j).size(); k++){
                sb.append(list.get(j).get(k));
            }
        }
        return sb.toString();
    }
}