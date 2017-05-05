package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

/**
 * Created by wa on 2017/5/3.
 */
public class ConsBTFromPreAndInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i;
        for (i = inStart; i < inEnd; i++) {
            if (inorder[i] == root.val) break;
        }
        root.left = build(preStart + 1, inStart, i - 1, preorder, inorder);
        root.right = build(preStart + i - inStart + 1, i + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] in = {2, 1, 3};
        System.out.println(buildTree(pre, in));
    }
}
