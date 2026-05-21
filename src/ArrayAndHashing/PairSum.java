package ArrayAndHashing;

//167. Two Sum II - Input Array Is Sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class PairSum {
    static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length -1;
        //< because we need two different numbers
        while(start<end){
            int currSum = numbers[start] + numbers[end];
            if(currSum == target){
                return new int[]{start+1, end+1};
            }else if(currSum > target){
                end--;
            }else {
                start++;
            }
        }
        return new int[]{-1,-1};
    }
}
