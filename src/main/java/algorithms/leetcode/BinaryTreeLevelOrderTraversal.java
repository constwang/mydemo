package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/4/14.
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        recurseZigZag(root, 0, result);
        return result;
    }

    public static void recurse(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) return;
        if (list.size() == level) list.add(new LinkedList<>());
        List<Integer> now = list.get(level);
        now.add(node.val);
        recurse(node.left, level + 1, list);
        recurse(node.right, level + 1, list);
    }

    public static void recurseZigZag(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) return;
        if (list.size() == level) list.add(new LinkedList<>());
        List<Integer> now = list.get(level);
        if (level % 2 == 0) now.add(node.val);
        else now.add(0, node.val);
        recurseZigZag(node.left, level + 1, list);
        recurseZigZag(node.right, level + 1, list);
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
        System.out.println(levelOrder(node));
    }
}
