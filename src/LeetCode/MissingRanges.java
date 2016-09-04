package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaun on 8/28/2016.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            if(lower == upper) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return res;
        }
        if(nums[0] > lower) {
            if(nums[0] == lower + 1) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
            }
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1] + 1) {
                continue;
            } else if(nums[i] == nums[i-1] + 2) {
                res.add(String.valueOf(nums[i] - 1));
            } else {
                res.add(String.valueOf(nums[i-1] + 1) + "->" + String.valueOf(nums[i] - 1));
            }
        }

        int last = nums[nums.length - 1];
        if(last < upper) {
            if(last + 1 == upper) {
                res.add(String.valueOf(upper));
            } else {
                res.add(String.valueOf(last + 1) + "->" + String.valueOf(upper));
            }
        }

        return res;
    }
}
