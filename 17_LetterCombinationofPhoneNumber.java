class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }

    private void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
        if (next_digits.isEmpty()) {
            output.add(combination);
        } else {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, next_digits.substring(1), phone_map, output);
            }
        }
    }
}


// class Solution {
//     String keys[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//     public List<String> letterCombinations(String digits) {
//         int l=digits.length();
//         ArrayList<String> res= new ArrayList<>();
//         function(digits,0,l,"",res);
//         return res;
//     }
//     public void function(String digits, int i, int l,String ans,ArrayList<String> res)
//     {
//         if(ans.length()==l)
//         {
//             if(ans.length()!=0)
//             res.add(ans);
//             return;
//         }
//         int num=digits.charAt(i)-'0';
//         for(int j=0;j<keys[num].length();j++)
//         {
//             function(digits,i+1,l,ans+keys[num].charAt(j),res);
//         }
//         return;    }
// }