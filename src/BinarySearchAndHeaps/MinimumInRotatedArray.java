package BinarySearchAndHeaps;

public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end + start)/2;
            //check if nums[mid]>end
            if(nums[mid]>nums[end]){
                //short element exist in right
                start = mid +1;
            }else {
                end = mid;
            }
        }
        return nums[start];
    }
}
