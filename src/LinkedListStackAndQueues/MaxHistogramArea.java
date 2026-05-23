package LinkedListStackAndQueues;

import java.util.Stack;

public class MaxHistogramArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //calculate nextSmaller index
        //calculate prevSmaller index
        int[] nextSmallerIndex = calculateNextSmaller(heights);
        int[] prevSmallerIndex = calculatePrevSmaller(heights);

        //next logic
        //now find the left smaller index and right smaller index
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int leftSmallerIndex = prevSmallerIndex[i];
            int rightSmallerIndex = nextSmallerIndex[i];

            int width = rightSmallerIndex - leftSmallerIndex - 1;
            int height = heights[i];

            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    private int[] calculateNextSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{-1, n});
        for(int i= n-1; i>=0; i--){
            while(st.peek()[0] < arr[i]){
                st.pop();
            }
            ans[i] = st.peek()[1];
            st.push(new int[]{arr[i], i});
        }
        return ans;
    }

    private int[] calculatePrevSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{-1, -1});
        for(int i= 0; i<n; i++){
            while(st.peek()[0] < arr[i]){
                st.pop();
            }
            ans[i] = st.peek()[1];
            st.push(new int[]{arr[i], i});
        }
        return ans;
    }
}
