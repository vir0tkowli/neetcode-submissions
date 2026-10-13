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
    StringBuilder rootStr = new StringBuilder();
    StringBuilder subrootStr = new StringBuilder();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root, true);
        dfs(subRoot, false);
        return rootStr.toString().contains(subrootStr.toString());
    }
    private void dfs(TreeNode cur, boolean parent) {
        if(cur == null) {
            (parent ? rootStr : subrootStr).append("#");
            System.out.printf("rootStr %s   subrootStr %s\n", rootStr, subrootStr);
            return;
        }
        (parent ? rootStr : subrootStr).append(cur.val);
        dfs(cur.left, parent);
        dfs(cur.right, parent);
    }
}
