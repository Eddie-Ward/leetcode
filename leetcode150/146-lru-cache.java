package leetcode150;

import java.util.HashMap;

class LRUCache {
    private HashMap<Integer, Node> nodeMap;
    private Node tailDummy; // tail.prev is true tail of LinkedList, representing the least recent value
    private Node headDummy; // head.next is true head of LinkedList, representing the most recent value
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>();

        headDummy = new Node(-1, -1);
        tailDummy = new Node(-1, -1);

        headDummy.next = tailDummy;
        tailDummy.prev = headDummy;

        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node targetNode = nodeMap.get(key);
        int val = targetNode.value;

        removeNode(targetNode);
        addNode(targetNode);

        return val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node targetNode = nodeMap.get(key);
            targetNode.value = value;

            removeNode(targetNode);
            addNode(targetNode);
        } else {
            if (this.size == this.capacity) {
                nodeMap.remove(tailDummy.prev.key);
                removeNode(tailDummy.prev);
                this.size--;
            }

            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            addNode(newNode);
            this.size++;
        }
    }

    private void addNode(Node newNode) {
        Node oldHead = headDummy.next;

        newNode.next = oldHead;
        newNode.prev = headDummy;

        headDummy.next = newNode;
        oldHead.prev = newNode;
    }

    private void removeNode(Node curNode) {
        Node prev = curNode.prev;
        Node next = curNode.next;

        prev.next = next;
        next.prev = prev;

    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
