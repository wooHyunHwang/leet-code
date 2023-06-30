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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        
        this.ans = 0;

        this.dfs(root, Integer.MIN_VALUE);


        return this.ans;
    }

    private void dfs(TreeNode root, int curMax) {
        if(root == null) return;

        curMax = Math.max(curMax, root.val);

        if(curMax <= root.val) this.ans++;

        this.dfs(root.left, curMax);
        this.dfs(root.right, curMax);
    }
}