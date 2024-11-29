package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution70 {

    public TreeNode invertTree(TreeNode root) {

        /* __________________________ BFS __________________________ */
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);
            TreeNode node, left;

            while (queue.isEmpty() == false) {
                node = queue.poll();

                // Swapping left and right
                left = node.left;
                node.left = node.right;
                node.right = left;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        /* __________________________ DFS __________________________ */
        // if ( root != null) {
        // final TreeNode left = root.left, right = root.right;

        // root.left = invertTree(right);
        // root.right = invertTree(left);
        // }

        return root;
    }
}
