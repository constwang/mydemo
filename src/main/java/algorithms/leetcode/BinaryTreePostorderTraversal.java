package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

import java.util.*;

/**
 * Created by wa on 2017/4/19.
 */
public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recurseTraversal(root, result);
        return result;
    }

    public static void recurseTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            recurseTraversal(root.left, list);
            recurseTraversal(root.right, list);
            list.add(root.val);
        }
    }

    public static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (!set.add(node)) {
                result.add(node.val);
                stack.pop();
                continue;
            }
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            } else {
                result.add(node.val);
                stack.pop();
            }
        }
        return result;
    }

    public static List<Integer> iterativeTraversal2(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                result.add(node.val);
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
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
        //node2.left = node3;
        node2.right = node4;
        node.left = node1;
        node.right = node2;
        System.out.println(iterativeTraversal(node2));
    }
}
