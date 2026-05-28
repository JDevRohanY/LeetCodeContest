package BinarySearchAndHeaps;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a,b) -> {return b-a;});
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //add number
        if(leftMaxHeap.peek()!=null && num <= leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }

        //now rebalance the size
        if(leftMaxHeap.size()>rightMinHeap.size()+1){
            //move from left to right
            rightMinHeap.add(leftMaxHeap.poll());
        }else if(leftMaxHeap.size()<rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        //if both size is equal
        if(!leftMaxHeap.isEmpty() && leftMaxHeap.size() == rightMinHeap.size()){
            return (leftMaxHeap.peek() + rightMinHeap.peek())/2.0;
        } else if(!leftMaxHeap.isEmpty()){
            return leftMaxHeap.peek();
        }
        return 0;
    }
}
