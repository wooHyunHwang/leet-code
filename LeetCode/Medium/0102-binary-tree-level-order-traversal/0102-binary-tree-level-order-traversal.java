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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans.clear();
        this.recursive(root, 0);
        return ans;
    }

    private void recursive(TreeNode node, int depth) {

        if (node == null) return;

        if (depth > ans.size() - 1) ans.add(new ArrayList<>());

        ans.get(depth).add(node.val);
        
        if (node.left != null) this.recursive(node.left, depth + 1);
        if (node.right != null) this.recursive(node.right, depth + 1);
    }
}