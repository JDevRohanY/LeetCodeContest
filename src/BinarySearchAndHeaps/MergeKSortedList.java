package BinarySearchAndHeaps;

import LinkedListStackAndQueues.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        //first create a min heap of size of lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(!pq.isEmpty()){
            //poll the element from pq
            ListNode top = pq.poll();
            //add it to next of curr
            curr.next = new ListNode(top.val);
            curr = curr.next;
            if(top.next!=null){
                pq.add(top.next);
            }
        }

        return head.next;
    }
}
