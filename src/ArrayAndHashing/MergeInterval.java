package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
//56. Merge Intervals
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        //first sort the array based on intital start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //now merge the interval
        List<int[]> ans = new ArrayList<>();
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            int tempStart = intervals[i][0];
            int tempEnd = intervals[i][1];
            if(currEnd>= tempStart){
                //interval can merge
                currEnd = Math.max(currEnd, tempEnd);
            }else{
                //interval cannot merge
                ans.add(new int[]{currStart, currEnd});
                currStart = tempStart;
                currEnd = tempEnd;
            }
        }
        //convert the ArrayList to int[]
        return ans.toArray(new int[ans.size()][2]);
    }
}
