import java.util.HashMap;
import java.util.Map;

public class offer07 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    static Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int pl, int ph, int[] inorder, int il, int ih) {
        TreeNode root = new TreeNode(preorder[pl]);
        int index = map.get(preorder[pl]);
        root.left = helper(preorder, pl + 1, pl + 1 + index - 1 - il, inorder, il, index - 1);
        root.right = helper(preorder, pl + 1 + index - 1 - il + 1, ph, inorder, index + 1, ih);
        return root;
    }
}
