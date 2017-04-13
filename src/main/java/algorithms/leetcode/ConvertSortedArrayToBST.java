package algorithms.leetcode;

import algorithms.tree.traversal.TreeNode;

/**
 * Created by wa on 2017/4/13.
 */
public class ConvertSortedArrayToBST {

    static class TreeNode {
        int val;
        //左子树
        TreeNode left;
        //右子树
        TreeNode right;

        //构造方法
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        add(root, true, nums, 0, mid - 1);
        add(root, false, nums, mid + 1, nums.length - 1);
        return root;
    }

    public static void add(TreeNode node, boolean isLeft, int[] num, int start, int end) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        TreeNode next = new TreeNode(num[mid]);
        if (isLeft) {
            node.left = next;
        } else {
            node.right = next;
        }
        add(next, true, num, start, mid - 1);
        add(next, false, num, mid + 1, end);
    }

    public TreeNode sortedArrayToBST2(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sortedArrayToBST(nums));
    }
}
