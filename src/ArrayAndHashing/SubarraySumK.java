package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int currSum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int totalCount = 0;
        for(int i=0; i<n; i++){
            currSum = currSum + nums[i];

            //now check whether currSum - k exist in prefixSum map or not
            if(prefixSum.containsKey(currSum-k)){
                totalCount += prefixSum.get(currSum-k);
            }

            //add prefix sum to map
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return totalCount;
    }
}
