package ThirtyDayPrep.Day_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    static void main() {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
            int y = target - x;
            //find y in set
            if(map.containsKey(y)){
                //this is the ans
                return new int[]{map.get(y), i};
            }
            map.putIfAbsent(x, i);
        }
        return new int[]{-1, -1};
    }
}
