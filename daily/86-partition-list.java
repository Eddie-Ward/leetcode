package daily;

/**
 * Two Queues Solution
 * 
 * Maintain two queues, one for smaller values and one for larger values
 * 
 * At the end, merge tail of smaller values to head of larger values
 * 
 */

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0);
        ListNode smallTail = smallHead, largeTail = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }
        largeTail.next = null; // Sever any connections to original next nodes to avoid cycle
        smallTail.next = largeHead.next; // Skip the sentinel node for large queue

        return smallHead.next;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
