package Arrays;
//https://leetcode.com/problems/product-of-array-except-self/description/
//238. Product of Array Except Self

public class ProductOfArrayExceptSelf {
    static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums2 = {-1, 1, 0, -3, 3};

        int[] ans = productExceptSelf(nums);
        printArray(ans);

        int[] ans2 = productExceptSelf(nums2);
        printArray(ans2);
    }

    public static int[] productExceptSelf(int[] nums) {
        //first we will calculate the left product
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i - 1];
        }

        //now we will calculate the ans
        int rightProduct = 1;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = leftProduct[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return ans;
    }

    private static void printArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
