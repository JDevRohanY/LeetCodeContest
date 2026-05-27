package BinarySearchAndHeaps;

public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            //check which side of array is correct
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                //this means left side is sorted
                //check is the target in left side?
                if(target<nums[mid] && target>=nums[start]){
                    //it means it is not present in left
                    end = mid -1;
                }else {
                    start = mid+1;
                }
            }else {
                // this means right side is sorted
                if(target>nums[mid] && target<=nums[end]){
                    //it means the target is not present in right
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
