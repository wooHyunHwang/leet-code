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
    public String tree2str(TreeNode root) {
        
        return this.dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs(TreeNode node, StringBuilder sb) {
        if(node == null) return sb;

        sb.append(node.val);

        if(node.left != null || node.right != null) {

            sb.append("(");

            if(node.left != null) this.dfs(node.left, sb);

            sb.append(")");

            if(node.right != null) {
                sb.append("(");
                this.dfs(node.right, sb);
                sb.append(")");
            }
        }

        return sb;
    }
}