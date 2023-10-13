package BST;

public class FloorInBST {

    class Node {
        int data;
        Node left;
        Node right;


        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    static int result = 0;

    public static int floor(Node root, int value) {
        if (root.data > value) {
            return 0;
        }
        inOrder(root, null, value);
        return result;
    }

    static void inOrder(Node root, Node prev, int value) {
        if (root == null) {
            return;
        }
        if (root.data == value) {
            result = root.data;
            System.out.println(result);
            return;
        } else if (root.data > value) {
            result = prev.data;
            System.out.println(result);
            return;
        }
        inOrder(root.left, root, value);
        inOrder(root.right, root, value);
    }

}
