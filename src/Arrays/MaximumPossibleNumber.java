package Arrays;

import java.util.PriorityQueue;


// https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/description/?envType=problem-list-v2&envId=array

// 3309. Maximum Possible Number by Binary Concatenation
public class MaximumPossibleNumber {

    public int maxGoodNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b)->{
           int ab = concatBits(a, b);
           int ba = concatBits(b, a);
           return  ba - ab;
        });

        for (int num : nums) {
            pq.add(num);
        }

        int ans = 0;
        while (!pq.isEmpty()){
            ans = concatBits(ans, pq.poll());
        }
        return ans;
    }

    private int concatBits(int a, int b) {
        if (b == 0) return a;
        int bitsInB = 32 - Integer.numberOfLeadingZeros(b);
        return (a << bitsInB) | a;
    }
}
