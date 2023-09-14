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
    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;

        return this.addTree(root, 0, 0);
    }

    private int addTree(TreeNode node, int ans, int stack) {
        stack = stack * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += stack;
            return ans;
        }

        if (node.left != null) ans = this.addTree(node.left, ans, stack);
        if (node.right != null) ans = this.addTree(node.right, ans, stack);

        return ans;
    }
}