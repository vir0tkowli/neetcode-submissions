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
    List<Integer> nodeList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root);
        
        return nodeList.get(k - 1);
    }
    private void preOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        preOrder(node.left);
        nodeList.add(node.val);
        preOrder(node.right);
    }
}
