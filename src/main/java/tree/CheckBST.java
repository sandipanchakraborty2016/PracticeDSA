package tree;

public class CheckBST {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        return isBalancedRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBalancedRec(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBalancedRec(root.left, min, root.data) && isBalancedRec(root.right, root.data, max);
    }
}
