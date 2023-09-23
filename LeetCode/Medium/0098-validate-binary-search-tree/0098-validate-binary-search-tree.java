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
    private long lastValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        this.lastValue = Long.MIN_VALUE;
        return this.dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) return true;

        if (node.left != null && !this.dfs(node.left)) return false;
        if (this.lastValue < node.val) {
            this.lastValue = node.val;
        }
        else return false;
        return this.dfs(node.right);
    }
}