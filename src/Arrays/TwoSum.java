package Arrays;
//https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//1. Two Sum
public class TwoSum {
    static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int req = target - nums[i];
            if(hm.containsKey(req)){
                return new int[]{i, hm.get(req)};
            }else{
                hm.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
