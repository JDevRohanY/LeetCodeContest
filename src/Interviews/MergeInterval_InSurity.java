package Interviews;

import java.util.*;

class Interval{
    int startTime;
    int endTime;
    public Interval(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class MergeInterval_InSurity {
    /*
     *   The class can only be Main
     */
    /*
    Input: arr[] = [[7, 8], [1, 5], [2, 4], [4, 6]]
    Output: [[1, 6], [7, 8]]
    */

    public static void main(String []args) {
        // code here
        Interval[] arr = new Interval[4];
        //create the array
        arr[0] = new Interval(7,8);
        arr[1] = new Interval(1,5);
        arr[2] = new Interval(2,4);
        arr[3] = new Interval(4,6);

        int n = 4;

        List<Interval> ans = mergeInterval(arr, n);

        //print the output
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i).startTime + ", " + ans.get(i).endTime);
        }

    }

    public static List<Interval> mergeInterval(Interval[] arr, int n){
        //or we can create a priorty queue
        //sort on the basis of start time
        //merge if the end time is greater then the start time of other
        PriorityQueue<Interval> pq = new PriorityQueue<>(
                (a,b)-> {
                    if(a!=b){
                        return a.startTime-b.startTime;
                    }else{
                        return a.endTime-b.endTime;
                    }
                }
        );
        //Iterate over arr, and add to priority queue
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        List<Interval> ans = new ArrayList<>();
        Interval top = pq.poll();
        while(!pq.isEmpty()){
            //we will fetch the second
            Interval temp = pq.poll();
            //compare with the top
            //check condition to merge
            if(top.endTime>=temp.startTime){
                //these will get merge
                top.startTime = top.startTime;
                top.endTime = Math.max(top.endTime, temp.endTime);
            }else{
                //they cannot merge
                //add it to list
                ans.add(top);
                top = temp;
            }
        }
        ans.add(top);
        return ans;
    }

}