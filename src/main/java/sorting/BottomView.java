package sorting;

import java.util.*;

// Problem link : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

public class BottomView {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Map<Node, Integer> views = new LinkedHashMap<>();
        views.put(root, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node currentNode = queue.poll();
            while (size > 0) {
                int hd = views.get(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    views.put(currentNode.left, hd - 1);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    views.put(currentNode.right, hd + 1);
                }
                size--;
            }
        }
        Map<Integer,Node> finals=new TreeMap<>();

        views.forEach((key, value) -> finals.put(value,key));

        finals.forEach((s,t)->result.add(t.data));

        return result;
    }

}
