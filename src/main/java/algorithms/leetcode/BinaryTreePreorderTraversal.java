package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wa on 2017/4/19.
 */
public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recurseTraversal(root, result);
        return result;
    }

    public static void recurseTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            recurseTraversal(root.left, list);
            recurseTraversal(root.right, list);
        }
    }

    public static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            result.add(root.val);
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    result.add(temp.val);
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return result;
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
        System.out.println(iterativeTraversal(node));
    }


}
