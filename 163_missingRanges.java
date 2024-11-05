import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length == 0) {
            List<Integer> out = new ArrayList<>();
            out.add(lower);
            out.add(upper);
            res.add(out);
            return res;
        }

        if (nums[0] > lower) {
            List<Integer> out = new ArrayList<>();
            out.add(lower);
            out.add(nums[0] - 1);
            res.add(out);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                List<Integer> out = new ArrayList<>();
                out.add(nums[i - 1] + 1);
                out.add(nums[i] - 1);
                res.add(out);
            }
        }

        if (nums[nums.length - 1] < upper) {
            List<Integer> out = new ArrayList<>();
            out.add(nums[nums.length - 1] + 1);
            out.add(upper);
            res.add(out);
        }

        return res;
    }
}
