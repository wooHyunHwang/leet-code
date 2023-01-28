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

    List<Integer> ans = null;

    public List<Integer> inorderTraversal(TreeNode root) {

        ans = new ArrayList<>();

        if(root == null) {
            return ans;
        } else {
            dfs(root);
            return ans;
        }
    }

    public void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            dfs(node.left);
        }

        ans.add(node.val);
        
        if(node.right != null) {
            dfs(node.right);
        }
    }


}