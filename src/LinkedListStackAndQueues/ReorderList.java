package LinkedListStackAndQueues;

//https://leetcode.com/problems/reorder-list/
//143. Reorder List
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode oneBeforeMiddle = findOneBeforeMiddle(head);
        ListNode list1 = head;
        ListNode list2 = oneBeforeMiddle.next;
        oneBeforeMiddle.next = null;

        //reverse list2
        ListNode reverseList2 = reverseList(list2);

        //merge both the list one after another
        head = mergeList(list1, reverseList2);
    }

    private ListNode findOneBeforeMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode node){
        ListNode temp = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode tempNext = curr.next;
            curr.next = temp;
            temp = curr;
            curr = tempNext;
        }
        return temp;
    }

    private ListNode mergeList(ListNode list1, ListNode list2){
        ListNode mergeHead = list1;
        while(list1!=null && list2!=null){
            //first point from list1 -> list2
            ListNode temp1 = list1.next;
            list1.next = list2;
            list1 = temp1;

            //then point from list2 -> list1
            ListNode temp2 = list2.next;
            list2.next = list1;
            list2 = temp2;
        }
        //don't need to do anything
        return mergeHead;
    }
}
