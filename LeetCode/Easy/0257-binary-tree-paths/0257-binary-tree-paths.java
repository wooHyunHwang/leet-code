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

    List<String> ans = null;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        find(root, sb);

        return ans;
        
    }

    void find(TreeNode root, StringBuilder sb) {
        if(root == null) return;

        if (sb.length() != 0) sb.append("->");
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        } else {
            if (root.left != null) find(root.left, new StringBuilder(sb.toString()));
            if (root.right != null) find(root.right, new StringBuilder(sb.toString()));
        }
    }
}