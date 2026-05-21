package ArrayAndHashing;

//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxWater = 0;
        while(start<=end){
            //calculate water for each
            int height1 = height[start];
            int height2 = height[end];
            int width = end - start;

            int water = Math.min(height1, height2) * width;
            if(water>maxWater){
                maxWater = water;
            }
            //iterate
            if(height1<height2){
                start++;
            }else{
                end--;
            }
        }
        return maxWater;

    }
}
