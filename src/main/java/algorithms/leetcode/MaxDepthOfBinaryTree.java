package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

/**
 * Created by wa on 2017/4/14.
 */
public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        return recurse(root, 0);
    }

    public static int recurse(TreeNode node, int depth) {
        if (node == null) return depth;
        return Math.max(recurse(node.left, depth + 1), recurse(node.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.right = node4;
        node.left = node1;
        node.right = node2;
        System.out.println(maxDepth(node));
    }
}
