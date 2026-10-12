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
    ArrayList<Integer> tree1 = new ArrayList<>();
    ArrayList<Integer> tree2 = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both positions are empty: they match.
        if (p == null && q == null) {
            return true;
        }

        // Only one position is empty: different structure.
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
