package LinkedListStackAndQueues;
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //reverse the linked list
        ListNode temp = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode tempNext = curr.next;
            curr.next = temp;
            temp = curr;
            curr = tempNext;
        }
        return temp;
    }
}
