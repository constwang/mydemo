package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

/**
 * Created by wa on 2017/4/14.
 */
public class ConstructBTfromPreAndInTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // TODO: 2017/4/14
        return null;
    }
}
