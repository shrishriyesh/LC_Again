class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l=0, r=products.length-1;
        for(int i=0;i<searchWord.length();i++)
        {
            List<String> temp = new ArrayList<>();
            while(l<=r && (products[l].length()<=i || products[l].charAt(i)<searchWord.charAt(i))) l++;
            while(l<=r && (products[r].length()<=i || products[r].charAt(i)>searchWord.charAt(i))) r--;
            for(int j=0;j<3 && l+j<=r;j++)
                temp.add(products[l+j]);
            res.add(temp);
        }
        return res;
    }
}