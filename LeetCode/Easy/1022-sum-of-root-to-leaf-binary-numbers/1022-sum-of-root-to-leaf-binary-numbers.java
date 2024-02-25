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
    private int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        this.ans = 0;
        recursive(root, 0, new int[1000]);
        return ans;
    }

    private void recursive(TreeNode node, int i, int[] bit) {

        bit[i] = node.val;

        if (node.left == null && node.right == null) {
            int digit = 1;
            int val = 0;
            for (; i > -1; --i) {
                if (bit[i] == 1) {
                    val += digit;
                }
                digit *= 2;
            }
            this.ans += val;

            return;
        }

        if (node.left != null) this.recursive(node.left, i+1, bit);
        if (node.right != null) this.recursive(node.right, i+1, bit);
    }
}