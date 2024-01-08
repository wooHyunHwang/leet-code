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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum = 0;
        this.dfs(root, low, high);
        return this.sum;
    }

    private void dfs(TreeNode node, int low, int high) {

        if (node == null) return;

        if (low <= node.val && node.val <= high) this.sum += node.val;

        this.dfs(node.left, low, high);
        if (node.val <= high) this.dfs(node.right, low, high);
    }

}