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
    public boolean evaluateTree(TreeNode node) {
        if (node.val == 2) return this.evaluateTree(node.left) || this.evaluateTree(node.right);
        else if (node.val == 3) return this.evaluateTree(node.left) && this.evaluateTree(node.right);
        else return node.val == 1;
    }
}