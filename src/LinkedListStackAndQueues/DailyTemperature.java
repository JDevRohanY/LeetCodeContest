package LinkedListStackAndQueues;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
//739. Daily Temperatures
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> nextBigger = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            int currTemp = temperatures[i];
            while(!nextBigger.isEmpty() && currTemp>=nextBigger.peek()[0]){
                nextBigger.pop();
            }
            if(nextBigger.isEmpty()){
                ans[i]=0;
            }else{
                ans[i] = nextBigger.peek()[1]-i;
            }
            nextBigger.add(new int[]{currTemp, i});
        }
        return ans;
    }
}
