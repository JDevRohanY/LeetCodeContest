package BinarySearchAndHeaps;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int half = (n+m)/2;

        int start = 0;
        int end = n;
        while(start <=end){
            //find the mid in the first array
            int i = (start + end) / 2;
            int j = half - i;

            int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int r1 = i == n ? Integer.MAX_VALUE : nums1[i];
            int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int r2 = j == m ? Integer.MAX_VALUE : nums2[j];

            //check if this is correct pair
            if(l1<=r2 && l2<=r1){
                //this is valid pair
                //if the length of element is odd or even
                if((n+m)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(r1,r2);
                }
            }
            //if this is not valid pair
            else if(l1>r2){
                end = i-1;
            }else{
                start = i+1;
            }
        }
        return -1;
    }
}
