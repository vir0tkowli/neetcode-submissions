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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean balanced = Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1 ;
        if (!balanced) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHeight(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(cur.left), maxHeight(cur.right));
    }
}
