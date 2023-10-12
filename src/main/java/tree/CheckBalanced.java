package tree;

public class CheckBalanced {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int lHeight=height(root.left);
        int rHeight=height(root.right);

        return Math.abs(lHeight-rHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }


}
