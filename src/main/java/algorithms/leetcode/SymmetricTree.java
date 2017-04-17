package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

/**
 * Created by wa on 2017/4/14.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

}
