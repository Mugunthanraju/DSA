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

class Solution86 {
    private int k;
    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.ans = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || ans > -1)
            return;

        dfs(node.left);

        --k;

        if (k == 0) {
            // we just need Kth Smallest element
            // so there is no need of storing k elements or all elements
            ans = node.val;
            return;
        }

        dfs(node.right);
    }
}