package LinkedListStackAndQueues;

public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //No need to create a new memory for each node every time you merge sorted
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1==null) ? list2 : list1;
        return ans.next;
    }
}
