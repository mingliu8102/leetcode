import java.util.LinkedList;
import java.util.List;

public class offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> list = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        int size = list.size();
        return list.get(size - k);

    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
