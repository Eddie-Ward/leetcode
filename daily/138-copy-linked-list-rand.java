package daily;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curNode = head;
        while (curNode != null) {
            oldToNew.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }

        curNode = head;
        while (curNode != null) {
            Node newNode = oldToNew.get(curNode);
            newNode.next = oldToNew.get(curNode.next);
            newNode.random = oldToNew.get(curNode.random);
            curNode = curNode.next;
        }

        return oldToNew.get(head);
    }
}