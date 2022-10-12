import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32ii {
    public class TreeNode {
        int val;
        offer32.TreeNode left;
        offer32.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = queue.size();
        int count = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
            }
            size = count;
            count = 0;
            res.add(new LinkedList<>(list));
        }

        return res;
    }
}
