public class offer28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null | b == null) return false;
        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
