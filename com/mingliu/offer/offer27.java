public class offer27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode();
        newRoot = root;
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);
        return newRoot;
    }
}
