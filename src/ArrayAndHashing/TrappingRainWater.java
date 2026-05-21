package ArrayAndHashing;


//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        //first calculate leftMax
        int currLeftMax = 0;
        for(int i=0; i<n; i++){
            leftMax[i] = currLeftMax;
            if(height[i]>currLeftMax){
                currLeftMax = height[i];
            }
        }

        //calculate rightMax
        int currRightMax = 0;
        for(int i=n-1; i>=0; i--){
            rightMax[i] = currRightMax;
            if(height[i]>currRightMax){
                currRightMax = height[i];
            }
        }

        //now calculate water above each pillar
        int totalWater = 0;
        for(int i=0; i<n; i++){
            if(height[i]<Math.min(leftMax[i], rightMax[i])){
                totalWater += Math.min(leftMax[i], rightMax[i])-height[i];
            }
        }

        return totalWater;
    }
}
