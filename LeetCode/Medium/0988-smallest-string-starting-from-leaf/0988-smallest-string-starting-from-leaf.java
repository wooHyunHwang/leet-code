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
    private List<String> data;
    public String smallestFromLeaf(TreeNode root) {
        this.data = new ArrayList<>();
        this.recursive(root, new StringBuilder());
        Collections.sort(this.data);
        return this.data.get(0);
    }

    private void recursive(TreeNode node, StringBuilder sb) {

        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            this.data.add(sb.reverse().toString());
            return;
        }

        if (node.right != null) this.recursive(node.right, new StringBuilder(sb.toString())); 
        if (node.left != null) this.recursive(node.left, sb); 
    }
}