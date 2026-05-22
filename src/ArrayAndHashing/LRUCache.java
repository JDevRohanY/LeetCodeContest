package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
public class LRUCache {
    private Node head, tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //check whether it is in map or not
        if(!map.containsKey(key)){
            return -1;
        }
        //remove from the linked list and add it to first
        Node node = map.get(key);
        remove(node);
        insertFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        //check if the key is in map
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.val = value;
            insertFirst(node);
        }else{
            //check capacity
            if(size == capacity){
                //remove the lru
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            //add to the map
            Node node = new Node(key, value);
            map.put(key, node);
            insertFirst(node);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    private void insertFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
        size++;
    }
}
