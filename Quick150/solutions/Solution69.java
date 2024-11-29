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

class Solution69 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If the both nodes are null then true
        if (p == null && q == null)
            return true;

        // If the either nodes are null then false
        if (p == null || q == null)
            return false;

        // If the both node values are not equal then false
        // else we check recurisvely for left and right nodes for both trees
        if (p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}