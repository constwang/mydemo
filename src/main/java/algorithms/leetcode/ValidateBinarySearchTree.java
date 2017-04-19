package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

import java.util.Stack;

/**
 * Created by wa on 2017/4/19.
 */
public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        long pre = (long) Integer.MIN_VALUE - 1;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val <= pre) return false;
            else pre = node.val;
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        // TODO: 2017/4/19 better solution
        return true;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node2.left = node3;
        node2.right = node4;
        node.left = node1;
        node.right = node2;
        System.out.println(isValidBST(node2));
    }
}
