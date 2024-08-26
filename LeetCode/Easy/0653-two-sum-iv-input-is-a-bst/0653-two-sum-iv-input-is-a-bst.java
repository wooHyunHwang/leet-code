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
    boolean[] history = new boolean[10_001];
    public boolean findTarget(TreeNode node, int k) {
        history = new boolean[20_001];
        return this.dfs(node, k);
    }
    
    private boolean dfs(TreeNode node, int k) {

        if (node == null) return false;

        int minus = k - node.val + 10_000;

        if (minus > 0 && minus < 20_001 && history[minus]) {
            return true;
        }

        history[node.val+10_000] = true;

        if (node.left != null && this.dfs(node.left, k)) {
            return true;
        }
        
        return node.right != null && this.dfs(node.right, k);
    }
}