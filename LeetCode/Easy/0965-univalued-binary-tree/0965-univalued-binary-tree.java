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
    public boolean isUnivalTree(TreeNode root) {
        return this.recursive(root, root.val);
    }
    private boolean recursive(TreeNode node, int same) {
        if (node == null) return true;

        if (!this.recursive(node.left, same)) return false;
        if (!this.recursive(node.right, same)) return false;

        return node.val == same;
    }
}