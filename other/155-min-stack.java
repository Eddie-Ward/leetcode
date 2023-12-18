package other;

class MinStack {

    private MinNode head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new MinNode(val, val, null);
        } else {
            MinNode newNode = new MinNode(val, Math.min(head.min, val), head);
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class MinNode {
        int val;
        int min;
        MinNode next;

        private MinNode(int val, int min, MinNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
