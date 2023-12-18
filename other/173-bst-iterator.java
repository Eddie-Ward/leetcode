package other;

import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    public int next() {
        TreeNode ans = stack.pop();

        TreeNode curNode = ans.right;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        return ans.val;
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
