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
    public TreeNode bstToGst(TreeNode root) {
        
        this.dfs(root, 0);

        return root;
    }

    private int dfs(TreeNode node, int stack) {
        
        if (node.right != null) stack = this.dfs(node.right, stack);

        node.val += stack;

        // System.out.println(node.val);

        if (node.left != null) return this.dfs(node.left, node.val);
        else return node.val;
    }
}