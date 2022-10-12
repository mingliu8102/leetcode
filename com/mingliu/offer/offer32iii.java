import java.util.*;

public class offer32iii {
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
        int level = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new ArrayDeque<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                //按层级翻转添加
                if (level % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

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
            level++;
        }

        return res;
    }
}
