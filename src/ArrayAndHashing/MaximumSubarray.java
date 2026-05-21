package ArrayAndHashing;

//53. Maximum Subarray
//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //if you encounter -ve sum, move both start and end
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int currSum = 0;
        while(start<n && end<n){
            currSum += nums[end];
            if(currSum >max){
                max = currSum;
            }
            //check curr sum is negative or positive
            if(currSum<=0){
                start = end + 1;
                end = start;
                currSum = 0;
            }else{
                end ++;
            }
        }
        return max;
    }
}
