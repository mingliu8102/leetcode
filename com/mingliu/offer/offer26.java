public class offer26 {
    public static void main(String[] args) {

        System.out.println(Integer.parseInt("111111111111111111111111111101", 2));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return same(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    private static boolean same(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null) return true;
        if (nodeA == null || nodeB == null) return false;
        return nodeA.val == nodeB.val && same(nodeA.left, nodeB.left) && same(nodeA.right, nodeB.right);
    }
}
