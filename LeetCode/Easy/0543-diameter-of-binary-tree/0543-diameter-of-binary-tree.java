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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        int last = this.maxLength(root, 0);
        return this.max > last ? this.max : last;
    }

    private int maxLength(TreeNode node, int len) {

        if (node == null) return len;

        if (node.left != null && node.right != null) {

            int left = this.maxLength(node.left, 1);
            int right = this.maxLength(node.right, 1);

            int sum = left + right;

            if (sum > this.max) this.max = sum;

            return left > right ? len + left : len + right;
        }
        else if (node.left != null) {
            return this.maxLength(node.left, len+1);
        }
        else if (node.right != null) {
            return this.maxLength(node.right, len+1);
        }

        return len;
    }
}