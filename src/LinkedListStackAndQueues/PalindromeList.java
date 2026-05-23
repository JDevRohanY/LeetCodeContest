package LinkedListStackAndQueues;

import java.util.Stack;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        //now create a stack
        Stack<Integer> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            st.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(slow!=null){
            if(!st.isEmpty() && slow.val != st.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
