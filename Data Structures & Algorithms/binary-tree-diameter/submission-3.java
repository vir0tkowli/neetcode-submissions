/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = maxDepth(root.left) + maxDepth(root.right);
        max = Math.max(max, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));

        return max;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
