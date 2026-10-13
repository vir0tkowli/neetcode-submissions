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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (identical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    private boolean identical(TreeNode c1, TreeNode c2) {
        if (c1 == null && c2 == null) {
            return true;
        }
        if(c1 != null && c2 != null && (c1.val == c2.val)){
            return identical(c1.left, c2.left) && identical(c1.right, c2.right);
        }
        
        return false;
        
    }
}
