package Interviews;

import java.util.List;

public class CalculateSeats_SmartCoinOlyv {
    static void main() {

    }
/*
            [2, 5] -> 20
            [1, 2] -> 10
            [1,3] -> 30
            [3,5] -> 20

            [0,20,0,0,0]
            [10,20,-10,0,0]
            [40,20,-10,-30,0]
            [40,20,10,-30,0]

 */

    //[i,j,k] -> 3
    public int[] calculate(List<List<Integer>> queries, int n){
        //first go through each query
        int[] ans = new int[n];
        //initially each would be 0
        //iterate to every query
        for(int i=0; i<queries.size(); i++){
            //for each query find i,j,k
            int start = queries.get(i).get(0);
            int end = queries.get(i).get(1);
            int val = queries.get(i).get(2);

            //now we modify the ans
            ans[start] = ans[start]+ val;
            if(end<n){
                ans[end] = ans[end]-val;
            }
        }
        //we will iterate and sum
        for(int i=1; i<n; i++){
            ans[i] = ans[i-1]+ ans[i];
        }
        return ans;
    }
}
