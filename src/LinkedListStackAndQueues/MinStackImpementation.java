package LinkedListStackAndQueues;
class ListNode2{
    int val;
    int minVal;
    ListNode2 next;
    ListNode2 prev;
    ListNode2(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
        next = null;
        prev = null;
    }
}
public class MinStackImpementation {
    ListNode2 head;
    ListNode2 tail;
    int currMin;
    int size;

    public MinStackImpementation() {
        currMin = Integer.MAX_VALUE;
        head = new ListNode2(0,0);
        tail = new ListNode2(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void push(int val) {
        //calculate curr Min
        if(val<currMin){
            currMin = val;
        }
        //add to head
        ListNode2 newNode = new ListNode2(val, currMin);
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public void pop() {
        //pop from head
        if(size == 0){
            return;
        }
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        if(size == 0){
            currMin = Integer.MAX_VALUE;
        }else{
            currMin = head.next.minVal;
        }
    }

    public int top() {
        if(size == 0){
            return 0;
        }
        return head.next.val;
    }

    public int getMin() {
        return head.next.minVal;
    }
}
