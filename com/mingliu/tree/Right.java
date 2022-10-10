import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Right {
    private class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {

    }

    private static Node dfs(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Stack<Node> stack = new Stack<>();
        Node next = null;
        int size = 1;
        while (!queue.isEmpty()) {
            int count = 0;
            while (size > 0) {
                Node node = queue.poll();
                size--;
                node.next = next;
                next = node;

                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
            }
            size = count;
            next = null;
        }
        return root;
    }
}
