package ThirtyDayPrep.Day_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int num : nums){
            ans.add(num);
        }
        return ans.size() != nums.length;
    }
    static void main() {

    }
}
