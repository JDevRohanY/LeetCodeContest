package Arrays;

public class SortTheArray {
    static void main() {
        int[] nums = {5,4,3,2,1};
        int[] ans = sortArray(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        //let do merge sort
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return mergeSort(nums, start, end);
    }

    public static int[] mergeSort(int[] nums, int start, int end){
        //base condition
        if(start == end){
            return new int[]{nums[start]};
        }
        int mid = (start + end)/2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid+1, end);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){
        int n = left.length;
        int m = right.length;
        int totalSize = n+m;
        int[] ans = new int[totalSize];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while(p1<n && p2<m){
            if(left[p1] <right[p2]){
                ans[i] = left[p1];
                i++;
                p1++;
            }else {
                ans [i] = right[p2];
                i++;
                p2++;
            }
        }
        while(p1<n){
            ans[i] = left[p1];
            i++; p1++;
        }
        while(p2<m){
            ans[i] = right[p2];
            i++; p2++;
        }
        return ans;
    }
}
