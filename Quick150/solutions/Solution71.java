package solutions;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Solution71 {

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        // Checking two extreme end nodes and nodes directing towards middle.
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return helper(root.left, root.right);
    }
}