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
    List<List<Integer>> rootNodes;
    TreeMap<Integer, List<Integer>> heightMap;
    public List<List<Integer>> findLeaves(TreeNode root) {
        rootNodes = new ArrayList<>();
        heightMap = new TreeMap<>();

        getHeight(root);

        for (List<Integer> nodes : heightMap.values()) {
            rootNodes.add(nodes);
        }

        return rootNodes;
    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int curHeight = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        System.out.println(curHeight);

        heightMap.putIfAbsent(curHeight, new ArrayList<>());
        heightMap.get(curHeight).add(root.val);
        return curHeight;
    }
}
